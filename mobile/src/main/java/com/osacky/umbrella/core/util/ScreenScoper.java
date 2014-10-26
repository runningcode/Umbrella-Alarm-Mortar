package com.osacky.umbrella.core.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.osacky.umbrella.core.anim.SimpleAnimationListener;
import com.osacky.umbrella.core.anim.Transitions;
import com.osacky.umbrella.util.Views;

import butterknife.ButterKnife;
import flow.Flow;
import flow.Layouts;
import mortar.Blueprint;
import mortar.Mortar;
import mortar.MortarScope;
import timber.log.Timber;

/**
 * A conductor that can swap subviews within a container view.
 * <p/>
 *
 * @param <S> the type of the screens that serve as a {@link mortar.Blueprint} for subview. Must
 *            be annotated with {@link flow.Layout}, suitable for use with {@link flow.Layouts#createView}.
 */
public class ScreenScoper<S extends Blueprint> implements CanShowScreen<S> {

    // Using static view ids to find and replace core layouts
    private final static int contentViewId = Views.generateViewId();

    private final Context   context;
    private final ViewGroup container;

    private AnimatorSet screenTransition;

    /**
     * @param container the container used to host child views. Typically this is a {@link
     *                  android.widget.FrameLayout} under the action bar. In this case
     *                  it is designed to hold two children - main content and a navigation
     *                  drawer.
     */
    public ScreenScoper(Context context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    public void showScreen(S newScreen, S oldScreen, final Flow.Direction direction) {

        final View oldChild = getContentView();

        if (destroyOldScope(newScreen, oldChild)) {
            storeViewState(oldChild, oldScreen);
            final View newChild = createNewChildView(newScreen, contentViewId);

            Transitions.AnimPair transitions = null;
            if (oldChild != null) {
                switch (direction) {
                    case FORWARD:
                        // Load animations from Transition annotations, store them into backstack and set them to views
                        storeTransitions(oldScreen, newScreen);
                        transitions = Transitions.forward(context, newScreen);
                        break;
                    case BACKWARD:
                        if (newScreen instanceof TransitionScreen) {
                            // Try to load animations from a screen and set them
                            int[] transitionIds = ((TransitionScreen) newScreen).getTransitions();
                            transitions = Transitions.backward(context, transitionIds);
                        }
                        break;
                    case REPLACE:
                        // no animations
                        break;
                }
            }

            if (oldChild != null) {
                // Settings animator for each view and removing the old view
                // after animation ends
                if (transitions != null) {
                    transitions.out.setAnimationListener(new SimpleAnimationListener() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    container.removeView(oldChild);
                                }
                            });
                        }
                    });
                    oldChild.setAnimation(transitions.out);
                    newChild.setAnimation(transitions.in);

                } else {
                    // remove view immediately if no transitions to run
                    container.removeView(oldChild);
                }
            }

            container.addView(newChild, 0);
        }

    }

    /**
     * Destroys old child scope if it was different than the new one. Returns true
     * if successful
     */
    protected boolean destroyOldScope(S screen, View oldChild) {
        MortarScope myScope = Mortar.getScope(context);
        if (oldChild != null) {
            MortarScope oldChildScope = Mortar.getScope(oldChild.getContext());
            if (oldChildScope.getName().equals(screen.getMortarScopeName())) {
                return false;
            }
            myScope.destroyChild(oldChildScope);
        }
        return true;
    }

    /**
     * Creates a new child View from a given screen and sets its view Id
     */
    protected View createNewChildView(S screen, final int viewId) {
        MortarScope myScope = Mortar.getScope(context);
        MortarScope newChildScope = myScope.requireChild(screen);
        Context childContext = newChildScope.createContext(context);
        View newChild = Layouts.createView(childContext, screen);
        newChild.setId(viewId);
        return newChild;
    }

    /**
     * Store view hierarchy state into a Screen that will be pushed into
     * the backstack of Flow
     */
    protected void storeViewState(View view, S screen) {
        if (screen != null && screen instanceof StateBlueprint) {
            SparseArray<Parcelable> state = new SparseArray<>();
            view.saveHierarchyState(state);
            ((StateBlueprint) screen).setViewState(state);
            Timber.i("Storing view state %s", state);
        }
    }

    /**
     * Store transitions that were used from one screen to another
     *
     * @param oldScreen
     * @param newScreen
     */
    private void storeTransitions(S oldScreen, S newScreen) {
        if (oldScreen != null && oldScreen instanceof TransitionScreen) {
            ((TransitionScreen) oldScreen).setTransitions(Transitions.getTransitionResources(newScreen.getClass()));
        }
    }

    private View getContentView() {
        return ButterKnife.findById(container, contentViewId);
    }
}

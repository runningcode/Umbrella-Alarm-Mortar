package com.osacky.umbrella.mortar;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import flow.Layouts;
import mortar.Blueprint;
import mortar.Mortar;
import mortar.MortarScope;

public class ScreenPagerAdapter<S extends Blueprint> extends PagerAdapter {
    private final List<S> screens;

    public ScreenPagerAdapter() {
        this.screens = new ArrayList<>();
    }

    @SafeVarargs
    public final void addScreen(S... newScreens) {
        Collections.addAll(screens, newScreens);
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        S screen = screens.get(position);
        MortarScope myScope = Mortar.getScope(container.getContext());
        MortarScope newChildScope = myScope.requireChild(screen);
        Context childContext = newChildScope.createContext(container.getContext());
        View newChild = Layouts.createView(childContext, screen);
        container.addView(newChild);
        return newChild;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = ((View) object);
        MortarScope myScope = Mortar.getScope(container.getContext());
        MortarScope childScope = Mortar.getScope(view.getContext());
        container.removeView(view);
        myScope.destroyChild(childScope);
    }

    @Override
    public int getCount() {
        return screens.size();
    }

    public final S getItem(int position) {
        return screens.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}

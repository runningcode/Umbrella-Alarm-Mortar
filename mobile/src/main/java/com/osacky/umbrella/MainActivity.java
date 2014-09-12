package com.osacky.umbrella;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.CoreView;
import com.osacky.umbrella.mortar.ActivityPresenter;
import com.osacky.umbrella.mortar.ActivityResultPresenter;
import com.osacky.umbrella.mortar.HasActivity;
import com.osacky.umbrella.mortar.PauseAndResumeActivity;
import com.osacky.umbrella.mortar.PauseAndResumePresenter;
import com.osacky.umbrella.ui.AppContainer;

import java.util.UUID;

import javax.inject.Inject;

import butterknife.ButterKnife;
import flow.Flow;
import mortar.Mortar;
import mortar.MortarActivityScope;
import mortar.MortarScope;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;

public class MainActivity extends ActionBarActivity
        implements ActionBarOwner.View, PauseAndResumeActivity, HasActivity {

    @Inject ActionBarOwner actionBarPresenter;
    @Inject ActivityPresenter mActivityPresenter;
    @Inject AppContainer appContainer;
    @Inject PauseAndResumePresenter pauseNarcPresenter;
    @Inject ActivityResultPresenter mResultPresenter;

    private ActionBarOwner.MenuAction actionBarMenuAction;
    private MenuItem                      menuItem;
    private MortarActivityScope activityScope;
    private CoreView coreView;
    private Flow flow;
    private ActionBar mActionBar;

    private boolean configurationChangeIncoming;
    private String  scopeName;
    private boolean resumed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isWrongInstance()) {
            finish();
            return;
        }

        MortarScope parentScope = Mortar.getScope(getApplication());
        activityScope = Mortar.requireActivityScope(parentScope, new CorePresenter(getScopeName()));
        activityScope.onCreate(savedInstanceState);

        Mortar.inject(this, this);

        mActionBar = getSupportActionBar();

        actionBarPresenter.takeView(this);
        mActivityPresenter.takeView(this);
        pauseNarcPresenter.takeView(this);
        mResultPresenter.takeView(this);
        ViewGroup container = appContainer.get(this, UmbrellaApplication.get(this));

        getLayoutInflater().inflate(R.layout.core, container);
        coreView = ButterKnife.findById(this, R.id.core_layout);

        flow = coreView.getFlow();
    }

    @Override protected void onResume() {
        super.onResume();
        resumed = true;
        pauseNarcPresenter.activityResumed();
    }

    @Override protected void onPause() {
        resumed = false;
        super.onPause();
        pauseNarcPresenter.activityPaused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (actionBarPresenter != null) {
            actionBarPresenter.dropView(this);
        }
        if (mActivityPresenter != null) {
            mActivityPresenter.dropView(this);
        }
        if (pauseNarcPresenter != null) {
            pauseNarcPresenter.dropView(this);
        }
        if (mResultPresenter != null) {
            mResultPresenter.dropView(this);
        }
        if (!configurationChangeIncoming) {
            if (!activityScope.isDestroyed()) {
                MortarScope parentScope = Mortar.getScope(getApplication());
                parentScope.destroyChild(activityScope);
            }
            activityScope = null;
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        configurationChangeIncoming = true;
        return activityScope.getName();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                return flow.goUp();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        activityScope.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (flow.goBack()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        if (Mortar.isScopeSystemService(name)) {
            return activityScope;
        }
        return super.getSystemService(name);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mResultPresenter.onActivityResult(requestCode, resultCode, data);
    }

    private String getScopeName() {
        if (scopeName == null) scopeName = (String) getLastCustomNonConfigurationInstance();
        if (scopeName == null) {
            scopeName = MainActivity.class.getName() + "-" + UUID.randomUUID().toString();
        }
        return scopeName;
    }

    private boolean isWrongInstance() {
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            boolean isMainAction = intent.getAction() != null && intent.getAction().equals(ACTION_MAIN);
            return intent.hasCategory(CATEGORY_LAUNCHER) && isMainAction;
        }
        return false;
    }

    @Override
    public void setShowHomeEnabled(boolean enabled) {
        mActionBar.setDisplayShowHomeEnabled(enabled);
    }

    @Override
    public void setUpButtonEnabled(boolean enabled) {
        mActionBar.setDisplayHomeAsUpEnabled(enabled);
    }

    @Override
    public void setMenu(@MenuRes int menu) {
    }

    @Override
    public void setVisibility(boolean visible) {
        if (visible) {
            mActionBar.show();
        } else {
            mActionBar.hide();
        }
    }

    @Override
    public void setColor(@ColorRes int color) {
    }

    @Override
    public void setClipping(boolean clip) {
    }

    @Override public boolean isRunning() {
        return resumed;
    }

    @Override public Context getMortarContext() {
        return this;
    }

    @Override public ActionBarActivity getActivity() {
        return this;
    }
}

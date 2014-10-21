package com.osacky.umbrella;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import javax.inject.Inject;

import butterknife.ButterKnife;
import flow.Flow;
import mortar.Mortar;
import mortar.MortarActivityScope;
import mortar.MortarScope;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;

public class MainActivity extends ActionBarActivity
        implements ActionBarOwner.Activity, PauseAndResumeActivity, HasActivity {

    @Inject protected ActionBarOwner mActionBarOwner;
    @Inject protected ActivityPresenter mActivityPresenter;
    @Inject protected AppContainer appContainer;
    @Inject protected PauseAndResumePresenter pauseNarcPresenter;
    @Inject protected ActivityResultPresenter mResultPresenter;

    private MortarActivityScope activityScope;
    private Flow flow;

    private boolean resumed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isWrongInstance()) {
            finish();
            return;
        }

        MortarScope parentScope = Mortar.getScope(getApplication());
        activityScope = Mortar.requireActivityScope(parentScope, new CorePresenter(this));
        Mortar.inject(this, this);

        activityScope.onCreate(savedInstanceState);

        ViewGroup container = appContainer.get(this, UmbrellaApplication.get(this));

        getLayoutInflater().inflate(R.layout.core, container);
        CoreView coreView = ButterKnife.findById(container, R.id.core_layout);

        flow = coreView.getFlow();

        mActionBarOwner.takeView(this);
        mActivityPresenter.takeView(this);
        pauseNarcPresenter.takeView(this);
        mResultPresenter.takeView(this);
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
        mActionBarOwner.dropView(this);
        mActivityPresenter.dropView(this);
        pauseNarcPresenter.dropView(this);
        mResultPresenter.dropView(this);
        if (isFinishing() && activityScope != null) {
            MortarScope parentScope = Mortar.getScope(getApplication());
            parentScope.destroyChild(activityScope);
            activityScope = null;
        }
        super.onDestroy();
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

    private boolean isWrongInstance() {
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            boolean isMainAction = intent.getAction() != null && intent.getAction().equals(ACTION_MAIN);
            return intent.hasCategory(CATEGORY_LAUNCHER) && isMainAction;
        }
        return false;
    }

    @Override public boolean isRunning() {
        return resumed;
    }

    @Override public ActionBarActivity getActivity() {
        return this;
    }

    @Override public MortarScope getScope() {
        return activityScope;
    }
}

package com.osacky.umbrella;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;

import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.CoreView;
import com.osacky.umbrella.ui.AppContainer;

import javax.inject.Inject;

import butterknife.ButterKnife;
import flow.Flow;
import mortar.Mortar;
import mortar.MortarActivityScope;
import mortar.MortarScope;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;

public class MainActivity extends ActionBarActivity {

    @Inject protected AppContainer appContainer;

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
    }

    @Override protected void onResume() {
        super.onResume();
        resumed = true;
    }

    @Override protected void onPause() {
        resumed = false;
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (isFinishing() && activityScope != null) {
            MortarScope parentScope = Mortar.getScope(getApplication());
            parentScope.destroyChild(activityScope);
            activityScope = null;
        }
        super.onDestroy();
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

    private boolean isWrongInstance() {
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            boolean isMainAction = intent.getAction() != null && intent.getAction().equals(ACTION_MAIN);
            return intent.hasCategory(CATEGORY_LAUNCHER) && isMainAction;
        }
        return false;
    }
}

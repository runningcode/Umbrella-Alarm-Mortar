package com.osacky.umbrella;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.CoreView;
import com.osacky.umbrella.ui.AppContainer;

import java.util.UUID;

import javax.inject.Inject;

import butterknife.ButterKnife;
import flow.Flow;
import hugo.weaving.DebugLog;
import mortar.Mortar;
import mortar.MortarActivityScope;
import mortar.MortarScope;
import timber.log.Timber;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;

public class MainActivity extends ActionBarActivity implements ActionBarOwner.View {

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    @Inject ActionBarOwner actionBarPresenter;
    @Inject AppContainer appContainer;

    private ActionBarOwner.MenuAction actionBarMenuAction;
    private MenuItem                      menuItem;
    private MortarActivityScope activityScope;
    private CoreView coreView;
    private Flow flow;
    private ActionBar mActionBar;

    private boolean configurationChangeIncoming;
    private String  scopeName;

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
        ViewGroup container = appContainer.get(this, UmbrellaApplication.get(this));

        if (!servicesConnected()) return;
        getLayoutInflater().inflate(R.layout.core, container);
        coreView = ButterKnife.findById(this, R.id.core_layout);

        flow = coreView.getFlow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (actionBarPresenter != null) {
            actionBarPresenter.dropView(this);
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
                return flow.goBack();
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

    @Override
    public Context getMortarContext() {
        return this;
    }

    @Override @DebugLog
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CONNECTION_FAILURE_RESOLUTION_REQUEST:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        finish();
                        startActivity(getIntent());
                        break;
                    case Activity.RESULT_CANCELED:
                        ErrorDialogFragment fragment = new ErrorDialogFragment();
                        fragment.setDialog(new AlertDialog.Builder(this)
                                .setMessage(R.string.play_error_close)
                                .setPositiveButton(android.R.string.ok,
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        })
                                .setCancelable(false)
                                .create());
                        fragment.show(getSupportFragmentManager(), "Play Error");
                        break;
                }
        }
    }

    public static class ErrorDialogFragment extends DialogFragment {
        // Global field to contain the error dialog
        private Dialog mDialog;
        // Default constructor. Sets the dialog field to null
        public ErrorDialogFragment() {
            super();
            mDialog = null;
        }
        // Set the dialog to display
        public void setDialog(Dialog dialog) {
            mDialog = dialog;
        }
        // Return a Dialog to the DialogFragment.
        @NonNull @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return mDialog;
        }
    }

    private boolean servicesConnected() {
        // Check that Google Play services is available
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            // In debug mode, log the status
            Timber.d("Google Play services is available.");
            // Continue
            return true;
            // Google Play services was not available for some reason.
            // resultCode holds the error code.
        } else {
            // Get the error dialog from Google Play services
            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
                    resultCode,
                    this,
                    CONNECTION_FAILURE_RESOLUTION_REQUEST);

            // If Google Play services can provide an error dialog
            if (errorDialog != null) {
                // Create a new DialogFragment for the error dialog
                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
                // Set the dialog in the DialogFragment
                errorFragment.setDialog(errorDialog);
                // Show the error dialog in the DialogFragment
                errorFragment.show(getSupportFragmentManager(), "Location Updates");
            }
            return false;
        }
    }
}

package com.osacky.umbrella.actionbar;

import android.support.v7.widget.Toolbar;

import com.osacky.umbrella.mortar.HasScope;

import hugo.weaving.DebugLog;
import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;
import timber.log.Timber;

public class ActionBarOwner extends Presenter<ActionBarOwner.Activity> {

    public interface Activity extends HasScope {
        void setSupportActionBar(Toolbar toolbar);
    }

    public ActionBarOwner() {
    }

    @DebugLog
    public void setToolbar(Toolbar toolbar) {
        Activity activity = getView();
        if (activity != null) {
            Timber.i("view was not null");
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    protected MortarScope extractScope(Activity activity) {
        return activity.getScope();
    }
}


package com.osacky.umbrella.actionbar;

import android.support.v7.widget.Toolbar;

import com.osacky.umbrella.mortar.HasScope;

import hugo.weaving.DebugLog;
import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;
import timber.log.Timber;

public class ActionBarOwner extends Presenter<ActionBarOwner.View> {

    public interface View extends HasScope {
        void setSupportActionBar(Toolbar toolbar);
    }

    public ActionBarOwner() {
    }

    @DebugLog
    public void setToolbar(Toolbar toolbar) {
        View view = getView();
        if (view != null) {
            Timber.i("view was not null");
            view.setSupportActionBar(toolbar);
        }
    }

    @Override
    protected MortarScope extractScope(View view) {
        return Mortar.getScope(view.getMortarContext());
    }
}


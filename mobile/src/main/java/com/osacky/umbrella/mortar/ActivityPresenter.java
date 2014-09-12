package com.osacky.umbrella.mortar;

import android.support.v7.app.ActionBarActivity;

import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;

public class ActivityPresenter extends Presenter<ActionBarActivity> {

    public ActivityPresenter() {
    }

    @Override protected MortarScope extractScope(ActionBarActivity view) {
        return Mortar.getScope(view);
    }

    public ActionBarActivity getActivity() {
        return getView();
    }
}

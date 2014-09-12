package com.osacky.umbrella.actionbar;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.osacky.umbrella.mortar.HasScope;

import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;
import rx.functions.Action0;

public class ActionBarOwner extends Presenter<ActionBarOwner.View> {

    public interface View extends HasScope {
        void setShowHomeEnabled(boolean enabled);

        void setUpButtonEnabled(boolean enabled);

        void setTitle(@StringRes int titleId);

        void setMenu(@MenuRes int menu);

        void setVisibility(boolean visible);

        void setColor(@ColorRes int color);

        void setClipping(boolean clip);
    }

    public static class MenuAction {
        @IdRes public final int id;
        public final Action0 action;

        public MenuAction(@IdRes int id, @NonNull Action0 action) {
            this.id = id;
            this.action = action;
        }
    }

    private ActionBarConfig config;

    public ActionBarOwner() {
    }

    @Override
    public void onLoad(Bundle savedInstanceState) {
        if (config != null) update();
    }

    public void setConfig(ActionBarConfig config) {
        this.config = config;
        update();
    }

    // Allow actionbar controller to add menu items with actions
    public boolean handleMenuClick(@IdRes int item) {
        for (MenuAction action : config.mMenuAction) {
            if (item == action.id) {
                action.action.call();
                return true;
            }
        }
        return false;
    }

    @Override
    protected MortarScope extractScope(View view) {
        return Mortar.getScope(view.getMortarContext());
    }

    private void update() {
        View view = getView();
        if (view == null) return;

        view.setShowHomeEnabled(config.showHomeEnabled);
        view.setUpButtonEnabled(config.upButtonEnabled);
        view.setTitle(config.titleId);
        view.setVisibility(config.visible);
        view.setColor(config.colorId);
        view.setClipping(config.clipToActionBar);
        view.setMenu(config.menuId);
    }
}


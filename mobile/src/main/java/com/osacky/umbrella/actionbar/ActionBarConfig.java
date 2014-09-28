package com.osacky.umbrella.actionbar;

import android.support.annotation.ColorRes;
import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;

import com.osacky.umbrella.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.osacky.umbrella.actionbar.ActionBarOwner.MenuAction;

public class ActionBarConfig {
    protected final boolean showHomeEnabled;
    protected final boolean upButtonEnabled;
    @StringRes protected final int titleId;
    protected final CharSequence titleString;
    @ColorRes protected final int colorId;
    @MenuRes protected final int menuId;
    protected final boolean visible;
    protected final boolean clipToActionBar;
    protected final List<MenuAction> mMenuAction;

    private ActionBarConfig(Builder builder) {
        showHomeEnabled = builder.showHomeEnabled;
        upButtonEnabled = builder.upButtonEnabled;
        titleString = builder.mTitleString;
        titleId = builder.mTitleId;
        visible = builder.visible;
        colorId = builder.mColorId;
        clipToActionBar = builder.clipToActionBar;
        menuId = builder.mMenuId;
        mMenuAction = builder.mMenuActions;
    }

    public static class Builder {
        private boolean showHomeEnabled = true;
        private boolean upButtonEnabled = false;
        // we need a default string for this or the app will crash
        @StringRes private int mTitleId = R.string.app_name;
        private CharSequence mTitleString = null;
        @ColorRes private int mColorId = R.color.theme_primary;
        // 0 is an invalid id
        @MenuRes private int mMenuId = 0;
        private boolean visible = true;
        private boolean clipToActionBar = true;
        private List<MenuAction> mMenuActions = new ArrayList<>();

        public Builder showHomeEnabled(boolean showHomeEnabled) {
            this.showHomeEnabled = showHomeEnabled;
            return this;
        }

        public Builder upButtonEnabled(boolean upButtonEnabled) {
            this.upButtonEnabled = upButtonEnabled;
            return this;
        }

        public Builder title(@StringRes int titleId) {
            mTitleId = titleId;
            return this;
        }

        public Builder title(CharSequence title) {
            mTitleString = title;
            return this;
        }

        public Builder visible(boolean visible) {
            this.visible = visible;
            return this;
        }

        public Builder color(@ColorRes int color) {
            mColorId = color;
            return this;
        }

        public Builder clipToActionBar(boolean clip) {
            clipToActionBar = clip;
            return this;
        }

        public Builder menu(@MenuRes int menuId, MenuAction... actions) {
            mMenuId = menuId;
            mMenuActions = Arrays.asList(actions);
            return this;
        }

        public ActionBarConfig build() {
            return new ActionBarConfig(this);
        }
    }
}

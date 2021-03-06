package com.osacky.umbrella.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.osacky.umbrella.core.util.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import flow.Layouts;
import mortar.Mortar;
import mortar.MortarScope;

public class ScreenPagerAdapter<S extends Path> extends PagerAdapter {
    private final List<S> mScreens = new ArrayList<>();

    public ScreenPagerAdapter() {
    }

    @SafeVarargs
    public final void addScreen(S... newScreens) {
        Collections.addAll(mScreens, newScreens);
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        S screen = mScreens.get(position);
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
        return mScreens.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}

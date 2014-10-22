/*
 * Copyright 2013 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.osacky.umbrella.util;

import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

public final class Utils {

    private static Typeface sMediumTypeface;

    private static SimpleDateFormat sBetterDateFormat;
    private static java.text.DateFormat sBackupDateFormat;


    public interface OnMeasuredCallback {
        void onMeasured(View view, int width, int height);
    }

    public static void waitForMeasure(final View view, final OnMeasuredCallback callback) {
        int width = view.getWidth();
        int height = view.getHeight();

        if (width > 0 && height > 0) {
            callback.onMeasured(view, width, height);
            return;
        }

        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override public boolean onPreDraw() {
                final ViewTreeObserver observer = view.getViewTreeObserver();
                if (observer.isAlive()) {
                    observer.removeOnPreDrawListener(this);
                }

                callback.onMeasured(view, view.getWidth(), view.getHeight());

                return true;
            }
        });
    }

    private static boolean hasL() {
        return SDK_INT >= LOLLIPOP;
    }

    private static boolean hasJB_MR2() {
        return SDK_INT >= JELLY_BEAN_MR2;
    }

    public static void setMediumTypeface(TextView textView) {
        if (hasL()) {
            if (sMediumTypeface == null) {
                sMediumTypeface = Typeface.create("sans-serif-medium", Typeface.NORMAL);
            }

            textView.setTypeface(sMediumTypeface);
        } else {
            textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        }
    }

    public static String formatDate(Date date) {
        if (hasJB_MR2()) {
            if (sBetterDateFormat == null) {
                sBetterDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "MMM d"));
            }
            return sBetterDateFormat.format(date);
        } else {
            if (sBackupDateFormat == null) {
                sBackupDateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT);
            }
            return sBackupDateFormat.format(date);
        }
    }

    private Utils() {
    }
}

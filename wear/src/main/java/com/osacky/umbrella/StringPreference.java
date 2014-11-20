package com.osacky.umbrella;

import android.content.SharedPreferences;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class StringPreference {
    private final SharedPreferences preferences;
    private final String key;
    private final String defaultValue;
    private BehaviorSubject<String> subject;

    public StringPreference(SharedPreferences preferences, String key) {
        this(preferences, key, null);
    }

    public StringPreference(SharedPreferences preferences, String key, String defaultValue) {
        this.preferences = preferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public Observable<String> observe() {
        if (subject == null)
            subject = BehaviorSubject.create(get());
        return subject;
    }

    public String get() {
        return preferences.getString(key, defaultValue);
    }

    public boolean isSet() {
        return preferences.contains(key);
    }

    public void set(String value) {
        preferences.edit().putString(key, value).apply();
        if (subject != null) {
            subject.onNext(value);
        }
    }

    public void delete() {
        preferences.edit().remove(key).apply();
    }
}

package com.osacky.umbrella.data.prefs;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ObjectPreference<T> implements Preference<T> {

    private final T defaultValue;
    private final Gson gson;
    private final String key;
    private final SharedPreferences preferences;
    private BehaviorSubject<T> subject;
    private final TypeToken<T> type;
    private T value;

    public ObjectPreference(SharedPreferences paramSharedPreferences, Gson paramGson,
                            TypeToken<T> paramTypeToken, String paramString, T paramT) {
        preferences = paramSharedPreferences;
        key = paramString;
        gson = paramGson;
        type = paramTypeToken;
        defaultValue = paramT;
    }

    public ObjectPreference(SharedPreferences paramSharedPreferences, Gson paramGson,
                            Class<T> paramClass, String paramString) {
        this(paramSharedPreferences, paramGson, paramClass, paramString, null);
    }

    public ObjectPreference(SharedPreferences paramSharedPreferences, Gson paramGson,
                            Class<T> paramClass, String paramString, T paramT) {
        this(paramSharedPreferences, paramGson, TypeToken.get(paramClass), paramString, paramT);
    }

    public void delete() {
        value = null;
        preferences.edit().remove(key).apply();
    }

    public T get() {
        if (value == null) {
            String str = preferences.getString(key, null);
            if (str == null)
                return defaultValue;
            value = gson.fromJson(str, type.getType());
        }
        return value;
    }

    public boolean isSet() {
        return preferences.contains(key);
    }

    public Observable<T> observe() {
        if (subject == null)
            subject = BehaviorSubject.create(get());
        return subject;
    }

    public void set(T paramT) {
        String str = gson.toJson(paramT, type.getType());
        preferences.edit().putString(key, str).apply();
        value = paramT;
        if (subject != null)
            subject.onNext(paramT);
    }
}

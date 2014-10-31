package com.osacky.umbrella.data.prefs;

public abstract interface Preference<T> {

  public abstract void delete();

  public abstract T get();

  public abstract boolean isSet();

  public abstract void set(T paramT);

}

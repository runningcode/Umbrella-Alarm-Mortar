package com.osacky.umbrella.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import timber.log.Timber;

public final class RollingTimberTree implements Timber.TaggedTree {

    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");
    private static final int MAX_MESSAGES = 512;
    private static final ThreadLocal<String> NEXT_TAG = new ThreadLocal<>();
    ArrayDeque<String> messages = new ArrayDeque<>();

    private static String createTag() {
        String tag = NEXT_TAG.get();
        if (tag != null) {
            NEXT_TAG.remove();
            return tag;
        }
        String str2 = new Throwable().getStackTrace()[5].getClassName();
        Matcher localMatcher = ANONYMOUS_CLASS.matcher(str2);
        if (localMatcher.find())
            str2 = localMatcher.replaceAll("");
        return str2.substring(1 + str2.lastIndexOf('.'));
    }

    private static String formatString(String paramString1, String paramString2, Object... objects) {
        String str = "%s: ".concat(paramString2);
        Object[] arrayOfObject = new Object[1 + objects.length];
        arrayOfObject[0] = paramString1;
        if (objects.length > 0)
            System.arraycopy(objects, 0, arrayOfObject, 1, objects.length);
        return String.format(str, arrayOfObject);
    }

    private static String formatString(Throwable throwable, String message, String paramString2, Object... args) {
        String str = "%s: ".concat(paramString2).concat("\n%s");
        Object[] arrayOfObject = new Object[2 + args.length];
        arrayOfObject[0] = message;
        StringWriter localStringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(localStringWriter));
        arrayOfObject[(1 + args.length)] = localStringWriter.toString();
        if (arrayOfObject.length > 2)
            System.arraycopy(args, 0, arrayOfObject, 1, args.length);
        return String.format(str, arrayOfObject);
    }

    private void record(String paramString) {
        messages.addLast(createTag() + ": " + paramString);
        int i = -MAX_MESSAGES + messages.size();
        for (int j = 0; j < i; j++)
            messages.removeFirst();
    }

    @Override
    public void d(String paramString, Object... args) {
        record(formatString(createTag(), paramString, args));
    }

    @Override
    public void d(Throwable paramThrowable, String paramString, Object... paramArrayOfObject) {
        record(formatString(paramThrowable, createTag(), paramString, paramArrayOfObject));
    }

    @Override
    public void e(String message, Object... args) {
        record(formatString(createTag(), message, args));
    }

    @Override
    public void e(Throwable throwable, String message, Object... args) {
        record(formatString(throwable, createTag(), message, args));
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(new ArrayList<>(messages));
    }

    @Override
    public void i(String message, Object... args) {
        record(formatString(createTag(), message, args));
    }

    @Override
    public void i(Throwable throwable, String message, Object... args) {
        record(formatString(throwable, createTag(), message, args));
    }

    @Override
    public void tag(String paramString) {
        NEXT_TAG.set(paramString);
    }

    @Override
    public void v(String paramString, Object... args) {
        record(formatString(createTag(), paramString, args));
    }

    @Override
    public void v(Throwable paramThrowable, String paramString, Object... args) {
        record(formatString(paramThrowable, createTag(), paramString, args));
    }

    @Override
    public void w(String paramString, Object... args) {
        record(formatString(createTag(), paramString, args));
    }

    @Override
    public void w(Throwable paramThrowable, String paramString, Object... args) {
        record(formatString(paramThrowable, createTag(), paramString, args));
    }
}

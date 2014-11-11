package com.osacky.umbrella.data.api;

import android.content.Context;
import android.os.StatFs;

import org.joda.time.DateTimeConstants;

import java.io.File;

public class ApiUtils {

    private static final int MAX_STALE = DateTimeConstants.SECONDS_PER_WEEK * 4;
    public static final String CACHE_CONTROL_HEADER_NAME = "Cache-Control";
    public static final String CACHE_CONTROL_HEADER_VALUE =
            "public, only-if-cached, max-stale=" + MAX_STALE;
    private static final String API_CACHE = "api-cache";
    private static final int MIN_DISK_CACHE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    // stolen from picasso
    public static File createDefaultCacheDir(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), API_CACHE);
        if (!cache.exists()) {
            //noinspection ResultOfMethodCallIgnored
            cache.mkdirs();
        }
        return cache;
    }

    // stolen from picasso
    public static long calculateDiskCacheSize(File dir) {
        long size = MIN_DISK_CACHE_SIZE;

        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            //noinspection deprecation
            long available = ((long) statFs.getBlockCount()) * statFs.getBlockSize();
            // Target 2% of the total space.
            size = available / 50;
        } catch (IllegalArgumentException ignored) {
        }

        // Bound inside min/max size for disk cache.
        return Math.max(Math.min(size, MAX_DISK_CACHE_SIZE), MIN_DISK_CACHE_SIZE);
    }

    private ApiUtils() {}
}

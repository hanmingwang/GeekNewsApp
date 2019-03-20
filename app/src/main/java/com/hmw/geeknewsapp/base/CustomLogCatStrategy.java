package com.hmw.geeknewsapp.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.LogStrategy;

/**
 * 适用于com.orhanobut:logger:2.2.0或更新版本
 * 解决日志打印错位不整齐的问题
 */
public class CustomLogCatStrategy implements LogStrategy {

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        Log.println(priority, randomKey() + tag, message);
    }

    private int last;

    private String randomKey() {
        int random = (int) (10 * Math.random());
        if (random == last) {
            random = (random + 1) % 10;
        }
        last = random;
        return String.valueOf(random);
    }
}

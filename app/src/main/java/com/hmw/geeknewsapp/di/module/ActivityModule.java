package com.hmw.geeknewsapp.di.module;

import android.app.Activity;

import com.hmw.geeknewsapp.di.scope.ActivityScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}

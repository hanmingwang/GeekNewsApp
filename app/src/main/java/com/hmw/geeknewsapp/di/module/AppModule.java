package com.hmw.geeknewsapp.di.module;

import com.hmw.geeknewsapp.base.BaseApplication;
import com.hmw.geeknewsapp.model.DataManager;
import com.hmw.geeknewsapp.model.http.HttpHelper;
import com.hmw.geeknewsapp.model.http.RetrofitHelper;
import com.hmw.geeknewsapp.model.prefs.ImplPreferencesHelper;
import com.hmw.geeknewsapp.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BaseApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, preferencesHelper);
    }

}

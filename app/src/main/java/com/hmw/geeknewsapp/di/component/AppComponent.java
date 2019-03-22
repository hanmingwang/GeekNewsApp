package com.hmw.geeknewsapp.di.component;

import com.hmw.geeknewsapp.base.BaseApplication;
import com.hmw.geeknewsapp.di.module.AppModule;
import com.hmw.geeknewsapp.di.module.HttpModule;
import com.hmw.geeknewsapp.model.DataManager;
import com.hmw.geeknewsapp.model.http.RetrofitHelper;
import com.hmw.geeknewsapp.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    BaseApplication getContext();  // 提供App的Context

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

}

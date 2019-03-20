package com.hmw.geeknewsapp.di.component;

import com.hmw.geeknewsapp.base.BaseApplication;
import com.hmw.geeknewsapp.di.module.AppModule;
import com.hmw.geeknewsapp.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    BaseApplication getContext();  // 提供App的Context
}

package com.hmw.geeknewsapp.di.component;

import android.app.Activity;

import com.hmw.geeknewsapp.di.module.ActivityModule;
import com.hmw.geeknewsapp.di.scope.ActivityScope;
import com.hmw.geeknewsapp.ui.MainActivity;
import com.hmw.geeknewsapp.ui.main.WelcomeActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);
}

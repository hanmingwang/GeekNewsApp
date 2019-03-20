package com.hmw.geeknewsapp.di.component;

import android.app.Activity;

import com.hmw.geeknewsapp.di.module.FragmentModule;
import com.hmw.geeknewsapp.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}

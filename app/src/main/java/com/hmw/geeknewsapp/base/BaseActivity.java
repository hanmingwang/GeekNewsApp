package com.hmw.geeknewsapp.base;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import com.hmw.geeknewsapp.di.component.ActivityComponent;
import com.hmw.geeknewsapp.di.component.DaggerActivityComponent;
import com.hmw.geeknewsapp.di.module.ActivityModule;
import com.hmw.geeknewsapp.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by han on 2018/7/5.
 * MVP activity基类
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    protected abstract void initInject();

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

//    @Override
//    protected int getLayout() {
//        return 0;
//    }
//
//    @Override
//    protected void initEventAndData() {
//
//    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }
}

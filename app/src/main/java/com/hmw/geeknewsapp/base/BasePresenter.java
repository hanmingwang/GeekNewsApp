package com.hmw.geeknewsapp.base;

/**
 * Created by han on 2018/7/4.
 * Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}

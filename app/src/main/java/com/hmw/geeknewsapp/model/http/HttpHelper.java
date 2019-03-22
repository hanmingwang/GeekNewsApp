package com.hmw.geeknewsapp.model.http;

import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;

import io.reactivex.Flowable;

public interface HttpHelper {

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

}

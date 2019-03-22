package com.hmw.geeknewsapp.model.http;

import com.hmw.geeknewsapp.model.http.api.ZhihuApis;
import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements HttpHelper{

    private final ZhihuApis mZhihuApiService;

    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService) {
        this.mZhihuApiService = zhihuApiService;
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }
}

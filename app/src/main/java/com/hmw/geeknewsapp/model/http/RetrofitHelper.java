package com.hmw.geeknewsapp.model.http;

import com.hmw.geeknewsapp.model.http.api.MyApis;
import com.hmw.geeknewsapp.model.http.api.ZhihuApis;
import com.hmw.geeknewsapp.model.http.response.MyHttpResponse;
import com.hmw.geeknewsapp.ui.main.bean.VersionBean;
import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements HttpHelper{

    private final ZhihuApis mZhihuApiService;
    private final MyApis mMyApiService;

    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService, MyApis myApiService) {
        this.mZhihuApiService = zhihuApiService;
        this.mMyApiService = myApiService;
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }

    @Override
    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mMyApiService.getVersionInfo();
    }
}

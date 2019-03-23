package com.hmw.geeknewsapp.model.http.api;

import com.hmw.geeknewsapp.model.http.response.MyHttpResponse;
import com.hmw.geeknewsapp.ui.main.bean.VersionBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MyApis {

    String HOST = "http://codeest.me/api/geeknews/";

    String APK_DOWNLOAD_URL = "http://codeest.me/apk/geeknews.apk";

    /**
     * 获取最新版本信息
     * @return
     */
    @GET("version")
    Flowable<MyHttpResponse<VersionBean>> getVersionInfo();

}

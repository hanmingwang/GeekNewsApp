package com.hmw.geeknewsapp.ui.main.contract;

import com.hmw.geeknewsapp.base.BasePresenter;
import com.hmw.geeknewsapp.base.BaseView;
import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}

package com.hmw.geeknewsapp.ui.main;

import com.hmw.geeknewsapp.base.BaseActivity;
import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;
import com.hmw.geeknewsapp.ui.main.contract.WelcomeContract;
import com.hmw.geeknewsapp.ui.main.presenter.WelcomePresenter;

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View{
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {

    }

    @Override
    public void jumpToMain() {

    }
}

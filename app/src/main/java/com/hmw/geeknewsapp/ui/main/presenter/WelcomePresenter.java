package com.hmw.geeknewsapp.ui.main.presenter;

import com.hmw.geeknewsapp.base.RxPresenter;
import com.hmw.geeknewsapp.ui.main.bean.WelcomeBean;
import com.hmw.geeknewsapp.ui.main.contract.WelcomeContract;
import com.hmw.geeknewsapp.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter{

    private static final int COUNT_DOWN_TIME = 2200;

    @Override
    public void getWelcomeData() {

    }

    private void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        mView.jumpToMain();
                    }
                })
        );
    }
}

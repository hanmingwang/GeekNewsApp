package com.hmw.geeknewsapp.ui.main.contract;

import com.hmw.geeknewsapp.base.BasePresenter;
import com.hmw.geeknewsapp.base.BaseView;
import com.tbruyelle.rxpermissions2.RxPermissions;

public interface MainContract {

    interface View extends BaseView {

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface  Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);

        void setNightModeState(boolean b);

        void setCurrentItem(int index);

        int getCurrentItem();

        void setVersionPoint(boolean b);

        boolean getVersionPoint();
    }
}


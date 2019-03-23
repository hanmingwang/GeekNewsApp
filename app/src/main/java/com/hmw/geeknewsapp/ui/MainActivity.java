package com.hmw.geeknewsapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.hmw.geeknewsapp.R;
import com.hmw.geeknewsapp.base.BaseActivity;
import com.hmw.geeknewsapp.component.UpdateService;
import com.hmw.geeknewsapp.ui.main.contract.MainContract;
import com.hmw.geeknewsapp.ui.main.presenter.MainPresenter;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            String versionName = pi.versionName;
            mPresenter.checkVersion(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showUpdateDialog(String versionContent) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("检测到新版本!");
        builder.setMessage(versionContent);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("马上更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkPermissions();
            }
        });
        builder.show();
    }

    @Override
    public void startDownloadService() {
        startService(new Intent(mContext, UpdateService.class));
    }

    public void checkPermissions() {
        mPresenter.checkPermissions(new RxPermissions(this));
    }
}

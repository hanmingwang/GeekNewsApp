package com.hmw.geeknewsapp.config;

import android.os.Environment;

import com.hmw.geeknewsapp.base.BaseApplication;

import java.io.File;

/**
 * Created by han on 2018/7/4.
 */

public class Constants {

    public static final String BUGLY_ID = "7ad13f4366";

    //================= PATH ====================

    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";
}

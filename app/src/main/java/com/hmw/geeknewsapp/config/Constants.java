package com.hmw.geeknewsapp.config;

import android.os.Environment;

import com.hmw.geeknewsapp.base.BaseApplication;

import java.io.File;

/**
 * Created by han on 2018/7/4.
 */

public class Constants {

    public static final String BUGLY_ID = "7ad13f4366";

    //================= TYPE ====================

    public static final int TYPE_ZHIHU = 101;

    public static final int TYPE_ANDROID = 102;

    public static final int TYPE_IOS = 103;

    public static final int TYPE_WEB = 104;

    public static final int TYPE_GIRL = 105;

    public static final int TYPE_WECHAT = 106;

    public static final int TYPE_GANK = 107;

    public static final int TYPE_GOLD = 108;

    public static final int TYPE_VTEX = 109;

    public static final int TYPE_SETTING = 110;

    public static final int TYPE_LIKE = 111;

    public static final int TYPE_ABOUT = 112;

    //================= PATH ====================

    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

    //================= PREFERENCE ====================

    public static final String SP_NIGHT_MODE = "night_mode";

    public static final String SP_NO_IMAGE = "no_image";

    public static final String SP_AUTO_CACHE = "auto_cache";

    public static final String SP_CURRENT_ITEM = "current_item";

    public static final String SP_LIKE_POINT = "like_point";

    public static final String SP_VERSION_POINT = "version_point";

    public static final String SP_MANAGER_POINT = "manager_point";

}

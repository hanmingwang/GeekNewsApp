package com.hmw.geeknewsapp.base;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.github.moduth.blockcanary.BlockCanary;
import com.hmw.geeknewsapp.config.Constants;
import com.hmw.geeknewsapp.utils.SystemUtil;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;

import static com.hmw.geeknewsapp.utils.LogUtil.isDebug;

/**
 * Created by han on 2018/7/4.
 */

public class BaseService extends IntentService {

    private static final String ACTION_INIT = "initApplication";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BaseService(String name) {
        super("BaseService");
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, BaseService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT.equals(action)) {
                initApplication();
            }
        }
    }

    private void initApplication() {
        //初始化日志
//        Logger.init(getPackageName()).hideThreadInfo();

        //初始化错误收集
//        CrashHandler.init(new CrashHandler(getApplicationContext()));
        initBugly();

        //初始化内存泄漏检测
        LeakCanary.install(BaseApplication.getInstance());

        //初始化过度绘制检测
        BlockCanary.install(getApplicationContext(), new BaseAppBlockCanaryContext()).start();

        //初始化tbs x5 webview
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    private void initBugly() {
        Context context = getApplicationContext();
        String packageName = context.getPackageName();
        String processName = SystemUtil.getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(context, Constants.BUGLY_ID, isDebug, strategy);
    }
}

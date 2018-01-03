package lyl.weather.application;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.rn.base.application.BaseApplication;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //异常界面
        CustomActivityOnCrash.install(this);

        //初始化工具类
        Utils.init(this);

        /**
         * 这是日志开关
         */
        LogUtils.getConfig().setLogSwitch(true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

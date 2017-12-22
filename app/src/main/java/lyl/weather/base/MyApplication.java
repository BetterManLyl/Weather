package lyl.weather.base;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
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

        /**
         * 这是日志开关
         */
       // LogUtils.getConfig().setLogSwitch(true);
    }
}

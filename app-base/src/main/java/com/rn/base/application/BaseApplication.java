package com.rn.base.application;

import android.app.Application;

/**
 * Created by Isay on 2017/1/5.
 */
public class BaseApplication extends Application {


    public static Application singleton;

    public static Application getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    /**
     * 初始化bmob
     */
//    public void initBomb() {
//        BmobConfig config = new BmobConfig.Builder(this)
//                .setApplicationId("877ce13233b7ee2f9c521311448586e6")
//                .setConnectTimeout(10)
//                .build();
//        Bmob.initialize(config);
//    }

}

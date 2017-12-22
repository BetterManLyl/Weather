package com.rn.base.user;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.rn.base.application.BaseApplication;

import java.util.ArrayList;
import java.util.Set;

/**
 * area_ip      北京*192.168.0.101：8888
 * my_address   192.168.0.101：8888
 * login_name   登录名
 * login_pass   登录密码
 * head_company 总公司
 * user_id      用户id
 * user_menu    用户菜单
 * real_name    真实姓名
 * userId_order_id    顺序巡检id
 * userId_order_num    顺序巡检-已巡检站数量
 * user_token    我的token值
 * jpush_alia    极光推送别名
 * new_version   新版本
 * server_uuid   服务其的uuid
 * home_tab_position  最后点击的home菜单页面tab的位置
 * worksheet_tab_position 最后点击的home菜单页面工单tab的位置
 */


public class LocalCfg {

    //本地配置
    public SharedPreferences localCfg;
    public SharedPreferences.Editor localEdit;


    //Context必须传递进来
    public LocalCfg() {
        Application app = BaseApplication.getInstance();
        Context context = app.getApplicationContext();
        localCfg = context.getSharedPreferences("config", context.MODE_PRIVATE);
        localEdit = localCfg.edit();
    }

    /**
     * 写本地配置 String
     */
    public void writeCfg(String name, String msg) {
        localEdit.putString(name, msg);
        localEdit.commit();
    }

    /**
     * 写本地配置 String
     */
    public void writeCfg(String name, boolean msg) {
        localEdit.putBoolean(name, msg);
        localEdit.commit();
    }

    /**
     * 读本地配置 String
     */
    public boolean readCfgBoolean(String name) {
        return localCfg.getBoolean(name, false);
    }


    /**
     * 写本地配置 set<String>
     */
    public void writeCfg(String name, Set<String> msg) {

        localEdit.putStringSet(name, msg);
        localEdit.commit();
    }

    /**
     * 读本地配置 String
     */
    public String readCfgStr(String name) {

        return localCfg.getString(name, "");
    }

    /**
     * 写本地配置 ing
     */
    public void writeCfg(String name, int msg) {

        localEdit.putInt(name, msg);
        localEdit.commit();
    }

    /**
     * 读本地配置 String
     */
    public int readCfgInt(String name) {
        return localCfg.getInt(name, -1);
    }

    /**
     * 读本地配置  set<String>
     */
    public Set<String> readCfgSet(String name) {
        return localCfg.getStringSet(name, null);
    }

}

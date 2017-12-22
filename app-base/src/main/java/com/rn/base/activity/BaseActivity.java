package com.rn.base.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Selection;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rn.base.Manager.ActivitiManager;
import com.rn.base.R;
import com.rn.base.utils.MyToast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Isay on 2017/1/4.
 */
public class BaseActivity extends AppCompatActivity {

    public static final String analysErr = "解析错误";
    public static final String QUERY_FAIL = "查询失败";
    public static final String SUBMIT_FAIL = "提交失败";
    public static final String SUBMIT_OK = "提交成功";
    public static boolean isUseTestInterface = false;
    //测试服务器地址
    public static final String TEST_INTERFACE = "199.28.0.207:8888";
    //通过主界面点击进来的都是1一级菜单，2二级菜单，3三级菜单
    public int menuLevel = 0;
    public TextView toolbarTitle;
    private long exitTime = 0;
    private int screenWidth;
    private int screenHeight;
    private String TAG=getClass().getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   Log.e("liyuelong",TAG+":onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
       // Log.e("liyuelong",TAG+":onPause");
        cancelToast();
        closeSysBoard();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Log.e("liyuelong",getClass().getSimpleName()+":onResume");
        cancelToast();
        closeSysBoard();
    }


    @Override
    public void onBackPressed() {
        onBackClick();
    }


    //这里也会出现问题，没退到主页面就直接推出了app lyl 2017.03.15
//    @Override
//    public void onTrimMemory(int level) {
//        if (level >= TRIM_MEMORY_RUNNING_LOW && (menuLevel > 0)) {
//            ActivitiManager.finishClassByName("class com.runachina.heatingmonitor.view.HomeActivity");
//        }
//        super.onTrimMemory(level);
//    }


    /**
     * 退出APP
     */
    public void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            //后台注销登陆
//            OkHttpUtils.post()
//                    .url("http://" + UserInfo.getInstance().getUserServerAddress() + "/web/module/phoneLogout.do")
//                    .build()
//                    .execute(null);
            //退出应用
            ActivitiManager.getAppManager().exitApp();
            finish();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
//        switch (level){
//            case TRIM_MEMORY_UI_HIDDEN:
//                showToast("界面不可见了");
//                break;
//        }

    }

    //获取手机日期
    public String getPhoneDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String phoneDate = format.format(new Date());
        return phoneDate;
    }

    //获取手机时间
    public String getPhoneTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String phoneTime = format.format(new Date());
        return phoneTime;
    }

    //获取手机时间
    public String getPhoneTimess() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String phoneTime = format.format(new Date());
        return phoneTime;
    }

    /**
     * normal_toolbar
     */
    public void setNormalToolBar(Toolbar toolbar, String title, int menuLevel) {
        this.menuLevel = menuLevel;
        if (toolbar == null) {
            return;
        } else {
            setSupportActionBar(toolbar);
        }
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText(title);
        //设置toolbar左侧返回键是否显示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick();
            }
        });
    }


    /**
     * 点击返回，toolbar和返回键
     */
    private void onBackClick() {
        finish();
    }


    /**
     * 显示toast信息
     */
    public void showToast(String msg) {
        if (!isNetworkConnected()) {
            msg = "请检查网络";
        }
        MyToast.showToast(this, msg);
    }


    /**
     * 取消toast
     */
    public void cancelToast() {
        MyToast.cancelToast();
    }


    //判断是否有网络连接
    public boolean isNetworkConnected() {
        ConnectivityManager manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = manager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }
        return false;
    }


    //判断WIFI网络是否可用
    public boolean isWifiConnected() {
        WifiManager manager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        boolean isWifiEnable = manager.isWifiEnabled();
        return isWifiEnable;
    }

    /**
     * 检测网络是否连接
     *
     * @return 2:WIFI  1:移动数据  0:无网络
     */
    public boolean isFlowConnected() {
        if ((isNetworkConnected()) && (!isWifiConnected())) {
            return true;
        }
        return false;
    }


    /**
     * 设置鼠标位置
     */
    public void setMouseInLast(EditText edit) {
        CharSequence text = edit.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }


    /**
     * 关闭系统键盘
     */
    public void closeSysBoard() {
        try {
            InputMethodManager imm = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm.isActive()) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    //取消Toast
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelToast();
    }

    //设置android app 的字体大小不受系统字体大小改变的影响
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}

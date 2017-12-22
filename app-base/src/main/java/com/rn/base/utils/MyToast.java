package com.rn.base.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Isay on 2016/8/13.
 */
public class MyToast {

    public static Toast toast;

    /**
     * 显示toast信息
     */
    public static void showToast(Context context, String msg) {
        if (null == toast) {
            toast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }


    /**
     * 取消toast
     */
    public static void cancelToast() {
        if (null != toast) {
            toast.cancel();
        }
    }
}

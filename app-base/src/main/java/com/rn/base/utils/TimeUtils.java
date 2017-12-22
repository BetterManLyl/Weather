package com.rn.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Isay on 2017/1/5.
 */
public class TimeUtils {


    /**
     * 获得手机当前小时
     */
    public static String getPhoneHour(int index) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, index * 1);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String phonetime = sdf.format(date);
        return phonetime;
    }

    /**
     * 获得手机当前时间("yyyy-MM-dd HH:mm:ss")
     */
    public static String getPhoneTime(int index) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, index * 10);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String phonetime = sdf.format(date);
        return phonetime;
    }

}

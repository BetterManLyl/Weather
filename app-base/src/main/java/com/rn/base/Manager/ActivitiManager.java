package com.rn.base.Manager;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Isay on 2017/1/5.
 */
public class ActivitiManager {

    private static Stack<Activity> activityStack;

    private static ActivitiManager activitiManager;


    //单一实例
    private ActivitiManager() {


    }

    //获取 ActivitiManager 实例
    public static ActivitiManager getAppManager() {
        if (activitiManager == null) {
            activitiManager = new ActivitiManager();
        }
        return activitiManager;
    }

    /**
     * add Activity 添加Activity到栈
     */
    public static void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * finish Activity
     */
    public static void finishActivity(Activity activity) {
        if (activityStack != null) {
            finishClassByName(activity.getClass().toString());
        }
    }


    /**
     * finish Activity
     */
    public static void finishActivity(Class _class) {
        if (activityStack != null) {
            finishClassByName(_class.toString());
        }
    }

    /**
     * 是否有这个 Activity的类
     */
    public static boolean isHasActivity(Class _class) {
        if (activityStack != null) {
            for (int i = 0, L = activityStack.size(); i < L; i++) {
                Class c = activityStack.get(i).getClass();
                if (c.equals(_class)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 是否有这个 Activity的类
     */
    public static boolean isHasActivity(String className) {
        if (activityStack != null) {
            for (int i = 0, L = activityStack.size(); i < L; i++) {
                String c = activityStack.get(i).getClass().toString();
                if (c.equals(className)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 通过类名结束栈中指定的类，并移除
     *
     * @param className
     */
    public static void finishClassByName(String className) {
        if (activityStack == null) {
            return;
        }
        int length = activityStack.size();
        boolean[] arr = new boolean[length];
        for (int i = 0; i < length; i++) { //需要栈中需要移除的类
            String name = activityStack.get(i) != null ? activityStack.get(i).getClass().toString() : "";
            if (className.equals(name)) {
                arr[i] = true;
            }
        }
        for (int index = 0, L = arr.length; index < L; index++) { //移除的类
            if (arr[index]) {
                activityStack.get(index).finish();
                activityStack.remove(index);
            }
        }
    }


    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        if (activityStack == null) {
            return;
        }
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 退出应用程序
     */
    public static void exitApp() {
        try {
            finishAllActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

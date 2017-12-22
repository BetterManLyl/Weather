package com.rn.base.okhttp.callback;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.rn.base.R;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by JimGong on 2016/6/23.
 */

public abstract class GenericsCallback<T> extends Callback<T> {
    IGenericsSerializator mGenericsSerializator;
    private ProgressDialog dialog;

    public GenericsCallback(IGenericsSerializator serializator) {
        mGenericsSerializator = serializator;
    }

    public GenericsCallback(IGenericsSerializator serializator, Activity activity, int type) {
        super();
        this.mGenericsSerializator = serializator;
        initDialog(activity, type);
    }

    //在请求接口之前添加 加载框
    private void initDialog(Activity activity, int type) {
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //不能在dialog.show()之前调用setContentView();
        //dialog.setContentView(R.layout.dialog_view);
        if (type == 1) {
            dialog.setMessage("登录中...");
        } else if (type == 2) {
            dialog.setMessage("查询中...");
        } else if (type == 3) {
            dialog.setMessage("注销中...");
        } else if (type == 4) {
            dialog.setMessage("提交中...");
        }
    }


    @Override
    public T parseNetworkResponse(Response response, int id) throws IOException {
        String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = mGenericsSerializator.transform(string, entityClass);
        return bean;
    }


    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
            // dialog.setContentView(R.layout.dialog_view);
        }
    }

    @Override
    public void onAfter(int id) {
        super.onAfter(id);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /**
     * 如果错误码返回的是401 已经在别处登录了，跳转到登录页面
     *
     * @param context
     * @param call
     * @param e
     * @param id
     */
    public void onError(Context context, Call call, Exception e, int id) {
        if (e.getMessage() != null) {
            if (e.getMessage().contains("reponse's code is : 401")) {
                if (context != null) {
                    Toast.makeText(context, "该帐号已在其他手机登录，如有疑问请联系管理员，请知悉!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();

                    intent.setClassName("com.runa.wisdomwaterplatform", "com.runa.wisdomwaterplatform.activity.LoginActivity");
                    context.startActivity(intent);
                }
            }
        }
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }
}

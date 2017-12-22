package com.rn.base.okhttp.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Window;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class IsayJsonCallback extends Callback<JSONObject> {
    private ProgressDialog dialog;

    //在请求接口之前添加 加载框
    private void initDialog(Activity activity, int type) {
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if (type == 1) {
            dialog.setMessage("登录中...");
        } else if (type == 2) {
            dialog.setMessage("查询中...");
        } else {
            dialog.setMessage("提交中...");
        }
    }

    public IsayJsonCallback(Activity activity, int type) {
        super();
        initDialog(activity, type);
    }

    public IsayJsonCallback() {
        super();
    }


    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(int id) {
        super.onAfter(id);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public JSONObject parseNetworkResponse(Response response, int id) throws IOException {

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response.body().string());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public void onError(Context context, Call call, Exception e, int id) {
        try {
            if (e.toString().contains("reponse's code is : 601") && context != null) {
                Intent intent = new Intent();
                intent.setClassName("com.runachina.heatingmonitor", "com.runachina.heatingmonitor.view.LoginActivity");
                context.startActivity(intent);
            }
//            if (e.toString().contains("reponse's code is : 500") && context != null) {
//                // 如果返回的是500，销毁页面
//                Activity activity = (Activity) context;
//                activity.finish();
//            }
        } catch (Exception exception) {
        }
    }
}

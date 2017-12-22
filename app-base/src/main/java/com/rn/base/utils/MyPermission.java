package com.rn.base.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rn.base.R;

/**
 * Created by Isay on 2016/8/15.
 */
public class MyPermission {

    public static final int CALL_PERSSION_PHONE = 1;
    public static final int CAMERA_PERSSION_CODE = 2;
    public static final int MIKE_PERSSION_CODE = 3;
    public static final int GPS_COARSE_REQUEST = 4;
    public static final int GPS_FINE_REQUEST = 5;

    public static final int  READ_EXTERNAL_STORAGE = 7;
    public static final int  WRITE_EXTERNAL_STORAGE = 8;


    public Context context;
    public AlertDialog alertDialog;

    public MyPermission(Context context) {
        this.context = context;

    }

    public void setContext(Context context){
        this.context = context;
    }


    //0点电话权限
    public boolean isCallPerssion() {
        if(Build.VERSION.SDK_INT >= 23){
            int callPhone = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);
            if(callPhone != PackageManager.PERMISSION_GRANTED){
                //检查权限
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},
                        CALL_PERSSION_PHONE);
                return false;
            }
        }
        return true;
    }


    //0检查并申请文件读写权限
    public boolean isStroagePerssion() {
        if(Build.VERSION.SDK_INT >= 23){
            int readPerssion = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePerssion = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if((readPerssion != PackageManager.PERMISSION_GRANTED) || (writePerssion != PackageManager.PERMISSION_GRANTED)){
                Activity ac = (Activity) context;
                ActivityCompat.requestPermissions(ac, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                        WRITE_EXTERNAL_STORAGE);
                return false;
            }
        }
        return true;
    }


    //2检查并申请摄像头权限
    public boolean isCameraPerssion() {
        if ((Build.VERSION.SDK_INT >= 23) && (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA))
                != PackageManager.PERMISSION_GRANTED) {
            //申请摄像头权限
            Activity ac = (Activity) context;
            ActivityCompat.requestPermissions(ac, new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERSSION_CODE);
            return false;
        }
        return true;
    }

    //3检查并申请麦克风权限
    public boolean isVoicePerssion() {
        if ((Build.VERSION.SDK_INT >= 23) && (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO))
                != PackageManager.PERMISSION_GRANTED) {
            //申请麦克风权限
            Activity ac = (Activity) context;
            ActivityCompat.requestPermissions(ac, new String[]{Manifest.permission.RECORD_AUDIO},
                    MIKE_PERSSION_CODE);//
            return false;
        }
        return true;
    }



    //gps是否开启
    public boolean isOpenGps() {
        boolean isOpen = true;
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            isOpen = false;
            MyToast.showToast(context,"请开启GPS");
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            Activity ac = (Activity) context;
            ac.startActivity(intent);
        }
        return isOpen;
    }


    //2提示打开权限
    public void showPermissionDialog(String title, String msg) {
        alertDialog = null ;
        //开启弹窗
        alertDialog = new android.support.v7.app.AlertDialog.Builder(context).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        //内容
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_normal, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        TextView tvContent = (TextView) view.findViewById(R.id.tv0);
        tvTitle.setText(title);
        tvContent.setText(msg);
        Button positiveBtn = (Button) view.findViewById(R.id.positive_button);
        positiveBtn.setText("确定");
        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
//                Uri packageURI = Uri.parse("package:" + "com.runachina.heatingmonitor");
//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
//                Activity ac = (Activity) context;
//                context.startActivity(intent);

                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);


            }
        });
        view.findViewById(R.id.negtive_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        //弹窗大小
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
        window.setContentView(view);
    }

}

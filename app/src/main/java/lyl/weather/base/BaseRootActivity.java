package lyl.weather.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.moudle.home.activity.ModifyPasswordActivity;
import lyl.weather.moudle.home.fragment.costprepay.activity.ShangHuActivity;

/**
 * @author lyl
 * @date 2017/12/27.
 */

public abstract class BaseRootActivity extends AppCompatActivity implements BaseControl.BaseView {

    private ProgressDialog progressDialog;
    private Context context;
    private long currentTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }


    @Override
    public Context getContext() {
        return context;
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showProgress(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(message);
        progressDialog.show();
    }


    @Override
    public void hideProgerss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this instanceof ModifyPasswordActivity || this instanceof ShangHuActivity) {
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                currentTime = System.currentTimeMillis();
            } else {
                RetrofitUtil.type=1;
                ActivityUtils.finishAllActivities();
                finish();
            }

        }
        return false;
    }
}

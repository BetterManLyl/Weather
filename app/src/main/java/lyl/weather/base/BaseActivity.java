package lyl.weather.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.rn.base.user.LocalCfg;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public abstract class BaseActivity extends FragmentActivity implements BaseView {
    public LocalCfg localCfg;
    Unbinder unbinder;
    private long currentTime = 0;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        unbinder = ButterKnife.bind(this);
        localCfg = new LocalCfg();
        initView();
    }

    @Override
    public void showToast(String message) {

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public abstract int layoutId();

    public abstract void initView();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                currentTime = System.currentTimeMillis();
            } else {
                ActivityUtils.finishAllActivities();
                finish();
            }

        }
        return false;
    }
}

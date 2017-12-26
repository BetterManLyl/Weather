package lyl.weather.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.rn.base.Manager.ActivitiManager;
import com.rn.base.user.LocalCfg;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import lyl.weather.R;
import lyl.weather.home.activity.ModifyPasswordActivity;
import lyl.weather.login.LoginActivity;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    public LocalCfg localCfg;
    Unbinder unbinder;
    private long currentTime = 0;
    private View rootView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = LayoutInflater.from(this).inflate(layoutId(), null);
        setContentView(rootView);
        ActivitiManager.addActivity(this);
        unbinder = ButterKnife.bind(this);
        localCfg = new LocalCfg();
        initView();
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


    private TextView tv_pop_messageTwo;
    private PopupWindow pop;

    /**
     * 弹出框
     *
     * @param title   标题
     * @param message 信息
     */
    public void showPop(String title, String message, String messageTwo, int type) {
        View popView = LayoutInflater.from(this).inflate(R.layout.pop_window_modify, null);
        TextView tv_pop_title = (TextView) popView.findViewById(R.id.tv_pop_title);
        TextView tv_pop_message = (TextView) popView.findViewById(R.id.tv_pop_message);
        tv_pop_messageTwo = (TextView) popView.findViewById(R.id.tv_pop_message_two);
        tv_pop_title.setText(title);
        tv_pop_message.setText(message);
        tv_pop_messageTwo.setText(messageTwo);
        pop = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackAlpha(0.7f);
        pop.setOutsideTouchable(false);
        pop.setBackgroundDrawable(null);
        pop.setFocusable(false);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        countDownTime(3,"请以新密码重新登录");
    }

    public void countDownTime(final int count, final String message){
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count + 1)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long integer) {
                        return count - integer;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {
                //关闭所有activity 跳转至登录界面
                Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
                startActivity(intent);
                localCfg.writeCfg("login_pass", "");
                finish();
                ActivitiManager.finishAllActivity();
                if (pop != null) {
                    pop.dismiss();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long integer) {
                tv_pop_messageTwo.setText( message+ "(" + integer + "s)");
            }
        });
    }
    /**
     * 设置弹出框弹出时，外部变暗
     *
     * @param alpha
     */
    public void setBackAlpha(float alpha) {
        WindowManager.LayoutParams lpParams = getWindow().getAttributes();
        lpParams.alpha = alpha;
        getWindow().setAttributes(lpParams);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this instanceof ModifyPasswordActivity) {
            return super.onKeyDown(keyCode, event);
        }
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

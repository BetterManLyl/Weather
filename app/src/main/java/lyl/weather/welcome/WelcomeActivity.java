package lyl.weather.welcome;

import android.content.Intent;

import lyl.weather.R;
import lyl.weather.base.BaseActivity;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class WelcomeActivity extends BaseActivity implements WelcomeView {

    private WelcomePresenter welcomePresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        welcomePresenter = new WelcomePresenterImpl(this);
        welcomePresenter.selfLogin(localCfg);
    }

    @Override
    public void showView() {

    }

    @Override
    public void goActivity(Class T) {
        startActivity(new Intent(this, T));
        finish();
    }

    @Override
    public void showToast(String message) {

    }
}

package lyl.weather.moudle.welcome;

import android.content.Intent;

import lyl.weather.R;
import lyl.weather.base.BaseActivity;
import lyl.weather.control.WelcomeControl;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class WelcomeActivity extends BaseActivity<WelcomeControl.WelcomePresenter,WelcomeControl.WelcomeView>
        implements WelcomeControl.WelcomeView {

    private WelcomeControl.WelcomePresenter welcomePresenter;

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

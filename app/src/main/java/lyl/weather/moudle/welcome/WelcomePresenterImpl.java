package lyl.weather.moudle.welcome;

import android.content.Context;
import android.text.TextUtils;

import com.rn.base.user.LocalCfg;

import lyl.weather.control.WelcomeControl;
import lyl.weather.moudle.HomeActivity;
import lyl.weather.moudle.login.LoginActivity;

/**
 * @author lyl
 * @date 2017/12/20.
 *
 */

public class WelcomePresenterImpl implements WelcomeControl.WelcomePresenter<WelcomeControl.WelcomeView> {

    /**
     * view层
     */
    private WelcomeControl.WelcomeView welcomeView;
    /**
     * model层
     */
    private WelcomeControl.IWelcomeModel iWelcomeModel;

    private String loginName = "";
    private String password = "";
    public WelcomePresenterImpl(WelcomeControl.WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        iWelcomeModel = new IWelcomeModelImpl();
    }

    @Override
    public void selfLogin(LocalCfg localCfg) {
        //获取缓存的用户名和密码
        loginName = localCfg.readCfgStr("login_name");
        password = localCfg.readCfgStr("login_pass");
        if (TextUtils.isEmpty(loginName) || TextUtils.isEmpty(password)) {
            welcomeView.goActivity(LoginActivity.class);
            return;
        }

        iWelcomeModel.login(loginName, password, new WelcomeControl.IWelcomeModel.OnLoginListener() {
            @Override
            public void success(String message) {
                /**
                 * 登录成功之后，获取菜单
                 */
                iWelcomeModel.getMenu(new WelcomeControl.IWelcomeModel.OnLoginListener() {
                    @Override
                    public void success(String message) {
                        /**
                         * 获取菜单成功之后，再跳转到首页
                         */
                        welcomeView.goActivity(HomeActivity.class);
                    }

                    @Override
                    public void error(String message) {
                        /**
                         * 获取菜单失败
                         */
                        welcomeView.goActivity(LoginActivity.class);
                    }
                });
            }

            @Override
            public void error(String message) {
                /**
                 * 登录失败
                 */
                welcomeView.goActivity(LoginActivity.class);
            }
        });


    }

    @Override
    public void saveUserInfo() {

    }


    @Override
    public void requestServer() {

    }

    @Override
    public Context getContext() {
        return welcomeView.getContext();
    }
}

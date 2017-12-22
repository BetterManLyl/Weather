package lyl.weather.welcome;

import android.text.TextUtils;

import com.rn.base.okhttp.callback.StringCallback;
import com.rn.base.user.LocalCfg;

import java.util.HashMap;
import java.util.Map;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.home.HomeActivity;
import lyl.weather.login.LoginActivity;
import lyl.weather.model.LoginSucess;
import lyl.weather.utils.MyUtils;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/20.
 *
 */

public class WelcomePresenterImpl implements WelcomePresenter {

    /**
     * view层
     */
    private WelcomeView welcomeView;
    /**
     * model层
     */
    private IWelcomeModel iWelcomeModel;

    private String loginName = "";
    private String password = "";
    public WelcomePresenterImpl(WelcomeView welcomeView) {
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

        iWelcomeModel.login(loginName, password, new IWelcomeModel.OnLoginListener() {
            @Override
            public void success(String message) {
                /**
                 * 登录成功之后，获取菜单
                 */
                iWelcomeModel.getMenu(new IWelcomeModel.OnLoginListener() {
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


}

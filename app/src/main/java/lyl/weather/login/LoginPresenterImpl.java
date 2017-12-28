package lyl.weather.login;

import android.content.Context;
import android.text.TextUtils;

import com.rn.base.user.LocalCfg;

import lyl.weather.base.ServerSuccessListener;
import lyl.weather.home.HomeActivity;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private IloginModel iloginModel;

    private LocalCfg localCfg;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        iloginModel = new IloginModelImp(this);
        localCfg = new LocalCfg();
    }


    @Override
    public void login(String userName, String userPass) {
        filiter(userName, userPass);

        iloginModel.login(userName, userPass, new ServerSuccessListener() {
            @Override
            public void success(Object o) {
                loginView.goActivity(HomeActivity.class);
            }

            @Override
            public void error(String message) {
                loginView.showToast(message);
            }
        });
    }

    @Override
    public void filiter(String userName, String userPass) {
        if (isEmpty(userName)) {
            loginView.filter("用户名不能为空");
            return;
        }
        if (isEmpty(userPass)) {
            loginView.filter("密码不能为空");
            return;
        }
    }


    public boolean isEmpty(String content) {
        if (!TextUtils.isEmpty(content)) {
            return false;
        }
        return true;
    }

    @Override
    public void requestServer() {

    }

    @Override
    public Context getContext() {
        return loginView.getContext();
    }


}

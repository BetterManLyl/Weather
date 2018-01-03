package lyl.weather.moudle.login;

import android.content.Context;
import android.text.TextUtils;

import lyl.weather.base.ServerSuccessListener;
import lyl.weather.control.LoginControl;
import lyl.weather.moudle.HomeActivity;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class LoginPresenterImpl implements LoginControl.LoginPresenter {

    private LoginControl.LoginView loginView;
    private LoginControl.IloginModel iloginModel;

    public LoginPresenterImpl(LoginControl.LoginView loginView) {
        this.loginView = loginView;
        iloginModel = new IloginModelImp(this);
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

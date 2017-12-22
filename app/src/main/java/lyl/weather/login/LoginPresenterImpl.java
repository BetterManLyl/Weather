package lyl.weather.login;

import android.content.Context;
import android.text.TextUtils;

import com.rn.base.user.LocalCfg;

import lyl.weather.home.HomeActivity;
import lyl.weather.welcome.IWelcomeModel;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private IloginModel iloginModel;

    private Context context;
    private LocalCfg localCfg;

    public LoginPresenterImpl(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
        iloginModel = new IloginModelImp();
        localCfg=new LocalCfg();
    }


    @Override
    public void login(String userName, String userPass) {
        loginView.showProgress("登录中...");
        filiter(userName, userPass);
        iloginModel.login(context, userName, userPass, new IWelcomeModel.OnLoginListener() {
            @Override
            public void success(String message) {
                loginView.hideProgerss();
                loginView.goActivity(HomeActivity.class);
            }

            @Override
            public void error(String message) {
                loginView.showToast(message);
                loginView.hideProgerss();
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

    @Override
    public void init() {
        String userName=localCfg.readCfgStr("login_name");
        String userPass=localCfg.readCfgStr("login_pass");
        if (!TextUtils.isEmpty(userName)){
            loginView.initEd(userName,userPass);
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
}

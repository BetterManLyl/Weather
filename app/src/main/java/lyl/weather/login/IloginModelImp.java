package lyl.weather.login;

import android.util.Log;

import com.rn.base.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.base.ServerSuccessListener;
import lyl.weather.model.LoginSucess;
import lyl.weather.model.Menu;
import lyl.weather.rxutil.ProgressSubscriber;
import lyl.weather.rxutil.SubscriberOnNextListener;
import lyl.weather.utils.MyUtils;
import lyl.weather.welcome.IWelcomeModel;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class IloginModelImp implements IloginModel {

    private String userPassMd = "";

    private LoginPresenter loginPresenter;

    public IloginModelImp(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;

    }

    @Override
    public void login(final String userName, final String userPass,
                      final ServerSuccessListener serverSuccessListener) {
        userPassMd = MyUtils.getMD5(userPass);
        Map<String, String> queryMap = new HashMap<>();

        queryMap.put("loginName", userName);
        queryMap.put("password", userPassMd);

        RetrofitUtil.getInstance().login(queryMap, new ProgressSubscriber<LoginSucess>
                (new SubscriberOnNextListener<LoginSucess>() {
            @Override
            public void onNext(LoginSucess loginSucess) {
                if (loginSucess.isResult()) {
                    //保存用户信息
                    UserInfo.getInstance().saveLoginUserInfo(loginSucess.getToken(), userName, userPass);
                    getMenu(serverSuccessListener);

                } else {
                    serverSuccessListener.error(loginSucess.getMessage());
                }
                Log.e("lyl", "onNext: " + loginSucess.getMessage());
            }

            @Override
            public void onError(int code, String message) {

            }
        },loginPresenter.getContext(),true));
    }

    @Override
    public void getMenu(final ServerSuccessListener serverSuccessListener) {
        RetrofitUtil.getInstance().getMenu(new Subscriber<Menu>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                serverSuccessListener.error("");
            }

            @Override
            public void onNext(Menu menu) {
                if (menu.getData().size() > 0) {
                    UserInfo.getInstance().saveMenu("费用预缴");
                } else {
                    UserInfo.getInstance().saveMenu("");
                }
                serverSuccessListener.success("登录成功");
            }
        });
    }


    @Override
    public void requestServer(RequestListener requestListener) {

    }

    @Override
    public void cancelRequest() {

    }
}

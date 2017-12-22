package lyl.weather.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.rn.base.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.model.LoginSucess;
import lyl.weather.model.Menu;
import lyl.weather.utils.MyUtils;
import lyl.weather.welcome.IWelcomeModel;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class IloginModelImp implements IloginModel {

    private String userPassMd = "";

    @Override
    public void login(Context context, final String userName, final String userPass,
                      final IWelcomeModel.OnLoginListener loginListener) {


        userPassMd = MyUtils.getMD5(userPass);
        Map<String, String> queryMap = new HashMap<>();

        queryMap.put("loginName", userName);
        queryMap.put("password", userPassMd);
        RetrofitUtil.getInstance().login(queryMap,
                new Subscriber<LoginSucess>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginSucess loginSucess) {
                        if (loginSucess.isResult()) {
                            //保存用户信息
                            UserInfo.getInstance().saveLoginUserInfo(loginSucess.getToken(), userName, userPass);
                            getMenu(loginListener);

                        } else {
                            loginListener.error(loginSucess.getMessage());
                        }
                        Log.e("lyl", "onNext: " + loginSucess.getMessage());
                    }
                });


    }

    @Override
    public void getMenu(final IWelcomeModel.OnLoginListener onLoginListener) {
        RetrofitUtil.getInstance().getMenu(new Subscriber<Menu>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoginListener.error("");
            }

            @Override
            public void onNext(Menu menu) {
                if (menu.getData().size() > 0) {
                    UserInfo.getInstance().saveMenu("费用预缴");
                } else {
                    UserInfo.getInstance().saveMenu("");
                }
                onLoginListener.success("登录成功");
            }
        });
    }

    @Override
    public void initView() {
        if (!TextUtils.isEmpty(UserInfo.getInstance().getUserName())){

        }
    }

    @Override
    public void requestServer(RequestListener requestListener) {

    }

    @Override
    public void cancelRequest() {

    }
}

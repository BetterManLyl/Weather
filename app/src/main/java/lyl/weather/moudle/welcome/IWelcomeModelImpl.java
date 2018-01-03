package lyl.weather.moudle.welcome;

import com.rn.base.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.control.WelcomeControl;
import lyl.weather.model.LoginSucess;
import lyl.weather.model.Menu;
import lyl.weather.utils.MyUtils;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class IWelcomeModelImpl implements WelcomeControl.IWelcomeModel {
    private Map<String, String> localHash = new HashMap<>();

    /**
     * 登录
     *
     * @param userName
     * @param userPass
     * @param onLoginListener
     */
    @Override
    public void login(final String userName, final String userPass, final OnLoginListener onLoginListener) {
        String password = MyUtils.getMD5(userPass);
        localHash.put("loginName", userName);
        localHash.put("password", password);

        RetrofitUtil.getInstance1().login(localHash, new Subscriber<LoginSucess>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoginListener.error("");
            }

            @Override
            public void onNext(LoginSucess loginSucess) {
                if (loginSucess.isResult()) {
                    MyUtils.loge(loginSucess.getMessage());
                    //保存用户信息
                    UserInfo.getInstance().saveLoginUserInfo(loginSucess.getToken(), userName, userPass);
                    getMenu(onLoginListener);
                } else {
                    onLoginListener.error("登录失败");
                }
            }
        });
    }

    /**
     * 获取菜单
     *
     * @param onLoginListener
     */
    @Override
    public void getMenu(final OnLoginListener onLoginListener) {
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
}

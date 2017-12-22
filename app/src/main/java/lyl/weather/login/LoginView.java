package lyl.weather.login;

import lyl.weather.base.BaseView;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface LoginView extends BaseView {

    /**
     * 获取用户名
     *
     * @return
     */
    String getUserName();

    /**
     * 获取密码
     *
     * @return
     */
    String getUserPass();


    void filter(String message);


    void goActivity(Class c);

    void initEd(String userName, String userPass);


    void loginSuccess();

}

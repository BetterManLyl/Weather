package lyl.weather.login;

import lyl.weather.base.IBasePresenter;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface LoginPresenter extends IBasePresenter{
    /**
     * 登录
     */
    void login(String userName, String userPass);

    void filiter(String userName, String userPass);

}

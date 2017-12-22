package lyl.weather.login;

import java.util.Map;

import lyl.weather.base.IBasePresenter;
import lyl.weather.base.Params;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface LoginPresenter extends IBasePresenter<Map<String,String>>{
    /**
     * 登录
     */
    void login(String userName,String userPass);


    void filiter(String userName,String userPass);

    void init();



}

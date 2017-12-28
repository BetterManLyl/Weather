package lyl.weather.login;

import lyl.weather.base.IBaseModel;
import lyl.weather.base.ServerSuccessListener;
import lyl.weather.welcome.IWelcomeModel;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public interface IloginModel extends IBaseModel{

    void login(String userName, String userPass,ServerSuccessListener serverSuccessListener);

    void getMenu( ServerSuccessListener serverSuccessListener);
}

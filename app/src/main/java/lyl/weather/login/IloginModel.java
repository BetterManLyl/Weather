package lyl.weather.login;

import android.content.Context;

import lyl.weather.base.IBaseModel;
import lyl.weather.welcome.IWelcomeModel;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public interface IloginModel extends IBaseModel{

    void login(Context context,String userName, String userPass,
               IWelcomeModel.OnLoginListener loginListener);

    void getMenu(IWelcomeModel.OnLoginListener onLoginListener);

    void initView();
}

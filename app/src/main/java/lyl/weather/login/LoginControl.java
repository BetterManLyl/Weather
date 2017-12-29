package lyl.weather.login;

import lyl.weather.base.BaseControl;
import lyl.weather.base.ServerSuccessListener;

/**
 * @author lyl
 * @date 2017/12/29.
 * login控制
 */


public interface LoginControl {

    interface IloginModel extends BaseControl.IBaseModel {
        void login(String userName, String userPass, ServerSuccessListener serverSuccessListener);
        void getMenu(ServerSuccessListener serverSuccessListener);
    }

    interface LoginPresenter extends BaseControl.IBasePresenter{
        void login(String userName, String userPass);
        void filiter(String userName, String userPass);
    }

    interface LoginView extends BaseControl.BaseView {
        void filter(String message);
        void goActivity(Class c);
    }
}

package lyl.weather.login;

import lyl.weather.base.BaseView;
import lyl.weather.base.IBaseModel;
import lyl.weather.base.IBasePresenter;
import lyl.weather.base.ServerSuccessListener;

/**
 * @author lyl
 * @date 2017/12/29.
 * login控制
 */


public interface LoginControl {

    interface IloginModel extends IBaseModel {
        void login(String userName, String userPass, ServerSuccessListener serverSuccessListener);
        void getMenu(ServerSuccessListener serverSuccessListener);
    }

    interface LoginPresenter extends IBasePresenter{
        void login(String userName, String userPass);
        void filiter(String userName, String userPass);
    }

    interface LoginView extends BaseView {
        void filter(String message);
        void goActivity(Class c);
    }
}

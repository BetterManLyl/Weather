package lyl.weather.control;

import com.rn.base.user.LocalCfg;

import lyl.weather.base.BaseControl;

/**
 * @author lyl
 * @date 2018/1/2.
 */

public interface WelcomeControl {
     interface IWelcomeModel {

        void login(String userName, String userPass,OnLoginListener onLoginListener);

        void getMenu(OnLoginListener onLoginListener);

        interface OnLoginListener {
            void success(String message);

            void error(String message);

        }
    }
     interface WelcomePresenter<V> extends BaseControl.IBasePresenter{

        /**
         * 自动登录
         */
        void selfLogin(LocalCfg localCfg);


        /**
         * 保存个人信息
         */
        void saveUserInfo();



    }
     interface WelcomeView extends BaseControl.BaseView{


        void showView();

        /**
         * 跳转
         */
        void goActivity(Class t);


    }

}

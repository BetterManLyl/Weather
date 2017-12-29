package lyl.weather.control;

import android.content.Context;

import lyl.weather.base.BaseView;
import lyl.weather.base.IBaseModel;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface MineControl {

    interface IMineModel {

        void getUserInfo(IBaseModel.RequestListener requestListener);

        void versionInfo(IBaseModel.RequestListener requestListener);
    }

    interface IMinePresenter {

        void getUserInfo();


        void showLogoutDialog();


        void getVersionInfo();


    }

    interface MineView extends BaseView {

        void getUserInfo(UserInfo userInfo);

        void goActivity(Class c);

        void versionInfo(VersionInfo versionInfo);

        Context getContexts();
    }

}

package lyl.weather.home.fragment.mine;

import android.content.Context;

import lyl.weather.base.BaseView;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public interface MineView extends BaseView{

    void getUserInfo(UserInfo userInfo);

    void goActivity(Class c);

    void versionInfo(VersionInfo versionInfo);

    Context getContexts();
}

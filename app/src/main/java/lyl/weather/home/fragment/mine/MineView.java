package lyl.weather.home.fragment.mine;

import lyl.weather.base.BaseView;
import lyl.weather.model.UserInfo;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public interface MineView extends BaseView{

    void getUserInfo(UserInfo userInfo);

    void checkVersion();
}

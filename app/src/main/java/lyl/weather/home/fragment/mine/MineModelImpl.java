package lyl.weather.home.fragment.mine;

import com.rn.base.user.LocalCfg;

import lyl.weather.base.IBaseModel;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class MineModelImpl implements IMineModel {
    @Override
    public void getUserInfo(IBaseModel.RequestListener requestListener) {
        lyl.weather.model.UserInfo userInfo = new lyl.weather.model.UserInfo();
        userInfo.setRealName(new LocalCfg().readCfgStr("real_name"));
        requestListener.success(userInfo);
    }
}

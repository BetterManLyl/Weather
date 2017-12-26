package lyl.weather.home.fragment.mine;

import lyl.weather.base.IBaseModel;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public interface IMineModel  {

    void getUserInfo(IBaseModel.RequestListener requestListener);

    void versionInfo(IBaseModel.RequestListener requestListener);
}

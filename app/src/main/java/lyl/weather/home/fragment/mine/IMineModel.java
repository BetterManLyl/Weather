package lyl.weather.home.fragment.mine;

import lyl.weather.base.IBaseModel;
import lyl.weather.model.LoginSucess;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public interface IMineModel  {

    void getUserInfo(IBaseModel.RequestListener requestListener);
}

package lyl.weather.home.activity;

import lyl.weather.home.fragment.currentcost.ICurrentModel;
import lyl.weather.model.ModifyPassword;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public interface IModifyModel {

    void modifyPass(ICurrentModel.GetSuccess<ModifyPassword> modifyPassGetSuccess);


}

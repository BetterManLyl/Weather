package lyl.weather.control;

import lyl.weather.api.ModifyPass;
import lyl.weather.base.BaseControl;
import lyl.weather.model.ModifyPassword;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface ModifyControl {

     interface IModifyModel {

        void modifyPass(CurrentCostControl.ICurrentModel.GetSuccess<ModifyPassword> modifyPassGetSuccess);


    }

     interface IModifyPresenter {

        void modifyPassword();

        ModifyPass getModifyPass();

        boolean filter();
    }


     interface ModifyView extends BaseControl.BaseView {


        String getOldPass();

        String getNewPass();

        String getConfirmPass();

        void showSuccessPop();
    }

}

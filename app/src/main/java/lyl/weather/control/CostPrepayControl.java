package lyl.weather.control;

import lyl.weather.base.BaseControl;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface CostPrepayControl {

     interface CostPrepayModel extends BaseControl.IBaseModel {
    }

     interface CostPrepayPresenter extends BaseControl.IBasePresenter {
    }

     interface CostPrepayView extends BaseControl.BaseView {
        String getEd();
    }
}

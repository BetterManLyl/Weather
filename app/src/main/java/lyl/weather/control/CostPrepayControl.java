package lyl.weather.control;

import lyl.weather.base.BaseView;
import lyl.weather.base.IBaseModel;
import lyl.weather.base.IBasePresenter;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface CostPrepayControl {

    public interface CostPrepayModel extends IBaseModel {
    }

    public interface CostPrepayPresenter extends IBasePresenter {
    }

    public interface CostPrepayView extends BaseView {
        String getEd();
    }


}

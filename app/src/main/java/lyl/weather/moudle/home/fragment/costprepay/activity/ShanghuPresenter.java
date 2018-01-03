package lyl.weather.moudle.home.fragment.costprepay.activity;

import java.util.List;

import lyl.weather.base.BaseControl;
import lyl.weather.model.Customers;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface ShanghuPresenter extends BaseControl.IBasePresenter {

    List<Customers.DataBean> getList();
    String getTrimStr();
}

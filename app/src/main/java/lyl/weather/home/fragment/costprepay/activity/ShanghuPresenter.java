package lyl.weather.home.fragment.costprepay.activity;

import java.util.List;

import lyl.weather.base.IBasePresenter;
import lyl.weather.model.Customers;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface ShanghuPresenter extends IBasePresenter {

    List<Customers.DataBean> getList();
    String getTrimStr();
}

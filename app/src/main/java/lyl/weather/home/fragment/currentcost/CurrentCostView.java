package lyl.weather.home.fragment.currentcost;

import lyl.weather.base.BaseView;
import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface CurrentCostView extends BaseView{


    void initData(CurrentCost currentCost);


    void initDataList(CurrentCostDatas currentCostDatas);


    void noDates();
}

package lyl.weather.home.fragment.currentcost;

import lyl.weather.base.IBaseModel;
import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public interface ICurrentModel{

    /**
     * 获取基本信息
     *
     * @param getSuccess
     */
    void getCurrentCost(GetSuccess<CurrentCost> getSuccess);

    /**
     * 获取信息成功
     *
     * @param getSuccess
     * @param term
     * @param pageIndex
     * @param pageSize
     */
    void getCurrentCostList(GetSuccess<CurrentCostDatas> getSuccess, String term, int pageIndex, int pageSize);

    interface GetSuccess<T> {
        void success(T t);

        void error();

        /**
         * 到底了
         */
        void noDatas();
    }

    void cleanData();
}

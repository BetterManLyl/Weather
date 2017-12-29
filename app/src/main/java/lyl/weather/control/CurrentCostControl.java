package lyl.weather.control;

import lyl.weather.base.BaseControl;
import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public interface CurrentCostControl {

     interface CurrentCostPresenter<T> {


        void initData();

        void initDataList(String term,int pageIndex,int pageSize,T t);

        void addAllDatas();

        void cleanDatas();

    }

     interface CurrentCostView extends BaseControl.BaseView {


        void initData(CurrentCost currentCost);


        void initDataList(CurrentCostDatas currentCostDatas);


        void noDates();
    }
     interface ICurrentModel{

        /**
         * 获取基本信息
         *
         * @param getSuccess
         */
        void getCurrentCost(ICurrentModel.GetSuccess<CurrentCost> getSuccess);

        /**
         * 获取信息成功
         *
         * @param getSuccess
         * @param term
         * @param pageIndex
         * @param pageSize
         */
        void getCurrentCostList(ICurrentModel.GetSuccess<CurrentCostDatas> getSuccess, String term, int pageIndex, int pageSize);

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
}

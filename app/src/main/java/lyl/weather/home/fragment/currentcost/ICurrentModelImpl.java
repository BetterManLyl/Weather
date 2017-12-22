package lyl.weather.home.fragment.currentcost;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.base.IBaseModel;
import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class ICurrentModelImpl implements ICurrentModel {


    @Override
    public void getCurrentCost(final GetSuccess getSuccess) {
        RetrofitUtil.getInstance().getCurrentcost(new Subscriber<CurrentCost>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getSuccess.error();
            }

            @Override
            public void onNext(CurrentCost currentCost) {
                getSuccess.success(currentCost);
            }
        });
    }

    @Override
    public void getCurrentCostList(final GetSuccess<CurrentCostDatas> getSuccess, String term,
                                   final int pageIndex, int pageSize) {
        RetrofitUtil.getInstance().getCurrentcostDatas(term,
                pageIndex, pageSize, new Subscriber<CurrentCostDatas>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getSuccess.error();
                    }

                    @Override
                    public void onNext(CurrentCostDatas currentCostDatas) {
                        if (pageIndex > currentCostDatas.getPageCount()) {
                            getSuccess.noDatas();
                        }else{
                            getSuccess.success(currentCostDatas);
                        }

                    }
                });
    }

    @Override
    public void cleanData() {

    }
}

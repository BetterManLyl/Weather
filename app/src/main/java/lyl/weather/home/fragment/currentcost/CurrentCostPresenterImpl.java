package lyl.weather.home.fragment.currentcost;

import java.util.List;

import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class CurrentCostPresenterImpl implements CurrentCostPresenter<List<CurrentCostDatas.DataBean>> {

    private ICurrentModel iCurrentModel;

    private CurrentCostView currentCostView;

    public CurrentCostPresenterImpl(CurrentCostView currentCostView) {
        this.currentCostView = currentCostView;
        iCurrentModel = new ICurrentModelImpl();
    }

    @Override
    public void initData() {
        iCurrentModel.getCurrentCost(new ICurrentModel.GetSuccess<CurrentCost>() {
            @Override
            public void success(CurrentCost currentCost) {
                currentCostView.initData(currentCost);
            }

            @Override
            public void error() {
                currentCostView.showToast("查询失败");
            }

            @Override
            public void noDatas() {

            }
        });
    }

    @Override
    public void initDataList(String term, int pageIndex, int pageSize, List<CurrentCostDatas.DataBean> dataBeen) {
        currentCostView.showProgress("查询中...");
        iCurrentModel.getCurrentCostList(new ICurrentModel.GetSuccess<CurrentCostDatas>() {
            @Override
            public void success(CurrentCostDatas currentCostDatas) {
                currentCostView.hideProgerss();
                currentCostView.initDataList(currentCostDatas);
            }

            @Override
            public void error() {
                currentCostView.hideProgerss();
                currentCostView.showToast("查询失败");
            }

            @Override
            public void noDatas() {
                currentCostView.hideProgerss();
                currentCostView.noDates();
            }
        }, term, pageIndex, pageSize);

    }

    @Override
    public void addAllDatas() {

    }

    @Override
    public void cleanDatas() {
        iCurrentModel.cleanData();

    }
}

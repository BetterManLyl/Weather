package lyl.weather.home.fragment.currentcost;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface CurrentCostPresenter<T> {


    void initData();

    void initDataList(String term,int pageIndex,int pageSize,T t);

    void addAllDatas();

    void cleanDatas();

}

package lyl.weather.home.fragment.costprepay;

import android.content.Context;

import lyl.weather.base.IBaseModel;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public class CostPrepayPresenterImpl implements CostPrepayPresenter {

    private CostPrepayView costPrepayView;
    private CostPrepayModel costPrepayModel;

    public CostPrepayPresenterImpl(CostPrepayView costPrepayView){
        this.costPrepayView=costPrepayView;
        costPrepayModel=new CostPrepayModelImpl();
    }

    @Override
    public void requestServer() {
        costPrepayModel.requestServer(new IBaseModel.RequestListener() {
            @Override
            public void success(Object o) {

            }

            @Override
            public void error() {

            }
        });
    }

    @Override
    public Context getContext() {
        return null;
    }
}

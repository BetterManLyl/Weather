package lyl.weather.home.fragment.costprepay;

import android.content.Context;


import lyl.weather.base.BaseControl;
import lyl.weather.control.CostPrepayControl;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public class CostPrepayPresenterImpl implements CostPrepayControl.CostPrepayPresenter {

    private CostPrepayControl.CostPrepayView costPrepayView;
    private CostPrepayControl.CostPrepayModel costPrepayModel;

    public CostPrepayPresenterImpl(CostPrepayControl.CostPrepayView costPrepayView){
        this.costPrepayView=costPrepayView;
        costPrepayModel=new CostPrepayModelImpl();
    }

    @Override
    public void requestServer() {
        costPrepayModel.requestServer(new BaseControl.IBaseModel.RequestListener() {
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

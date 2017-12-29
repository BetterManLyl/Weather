package lyl.weather.home.fragment.costprepay.activity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import lyl.weather.base.IBaseModel;
import lyl.weather.base.IBasePageModel;
import lyl.weather.model.Customers;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public class ShanghuPresenterImpl implements ShanghuPresenter {

    private ShanghuView shanghuView;
    private IBaseModel shanghuModel;
    private Customers customer;

    List<Customers.DataBean> dataBeen = new ArrayList<>();

    public ShanghuPresenterImpl(ShanghuView shanghuView) {

        this.shanghuView = shanghuView;
        shanghuModel = new ShanghuModelImpl(this);
    }

    @Override
    public void requestServer() {
        shanghuModel.requestServer(new IBaseModel.RequestListener<Customers>() {
            @Override
            public void success(Customers customers) {
                customer = customers;
                shanghuView.notifychanged();
            }

            @Override
            public void error() {

            }
        });
    }

    @Override
    public Context getContext() {
        return shanghuView.getContext();
    }

    @Override
    public String getTrimStr() {
        return shanghuView.getTrimStr();
    }

    @Override
    public List<Customers.DataBean> getList() {
        if (dataBeen==null){
            dataBeen=new ArrayList<>();
        }
        if (customer != null) {
            dataBeen.addAll(customer.getData());
            return dataBeen;
        }
        return dataBeen;
    }
}

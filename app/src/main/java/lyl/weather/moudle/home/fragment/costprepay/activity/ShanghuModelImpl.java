package lyl.weather.moudle.home.fragment.costprepay.activity;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.base.BaseControl;
import lyl.weather.model.Customers;
import lyl.weather.rxutil.ProgressSubscriber;
import lyl.weather.rxutil.SubscriberOnNextListener;

/**
 * @author lyl
 * @date 2017/12/29.
 */

public class ShanghuModelImpl implements BaseControl.IBaseModel {

    private ShanghuPresenter shanghuPresenter;

    public ShanghuModelImpl(ShanghuPresenter shanghuPresenter){
        this.shanghuPresenter=shanghuPresenter;
    }

    @Override
    public void requestServer(final RequestListener requestListener) {
        RetrofitUtil.getInstance().getCustom(shanghuPresenter.getTrimStr(),
                new ProgressSubscriber<Customers>(new SubscriberOnNextListener<Customers>() {
                    @Override
                    public void onNext(Customers customers) {
                        requestListener.success(customers);
                    }

                    @Override
                    public void onError(int code, String message) {
                        requestListener.error();
                    }
                }, shanghuPresenter.getContext(), true));
    }

    @Override
    public void cancelRequest() {

    }


}

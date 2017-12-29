package lyl.weather.home.activity;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.control.ModifyControl;
import lyl.weather.home.fragment.currentcost.ICurrentModel;

import lyl.weather.model.ModifyPassword;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public class IModifyModelImpl implements ModifyControl.IModifyModel {
    private ModifyControl.IModifyPresenter iModifyPresenter;

    public IModifyModelImpl(ModifyControl.IModifyPresenter iModifyPresenter) {
        this.iModifyPresenter = iModifyPresenter;
    }

    @Override
    public void modifyPass(final ICurrentModel.GetSuccess<ModifyPassword> modifyPassGetSuccess) {

        RetrofitUtil.getInstance()
                .modifyPass(iModifyPresenter.getModifyPass(),
                        new Subscriber<ModifyPassword>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                modifyPassGetSuccess.error();
                            }

                            @Override
                            public void onNext(ModifyPassword modifyPass) {
                                modifyPassGetSuccess.success(modifyPass);
                            }
                        });
    }
}

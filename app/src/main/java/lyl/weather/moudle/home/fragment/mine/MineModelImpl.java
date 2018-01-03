package lyl.weather.moudle.home.fragment.mine;

import com.rn.base.user.LocalCfg;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.base.BaseControl;
import lyl.weather.control.MineControl;
import lyl.weather.model.VersionInfo;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class MineModelImpl implements MineControl.IMineModel {

    private MineControl.IMinePresenter iMinePresenter;

    public MineModelImpl(MineControl.IMinePresenter iMinePresenter) {
        this.iMinePresenter = iMinePresenter;
    }

    @Override
    public void getUserInfo(BaseControl.IBaseModel.RequestListener requestListener) {
        lyl.weather.model.UserInfo userInfo = new lyl.weather.model.UserInfo();
        userInfo.setRealName(new LocalCfg().readCfgStr("real_name"));
        requestListener.success(userInfo);
    }

    @Override
    public void versionInfo(final BaseControl.IBaseModel.RequestListener requestListener) {
        RetrofitUtil.getInstance()
                .getVersionInfo(new Subscriber<VersionInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        requestListener.error();
                    }

                    @Override
                    public void onNext(VersionInfo versionInfo) {

                        requestListener.success(versionInfo);
                    }
                });
    }


}

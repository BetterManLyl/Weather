package lyl.weather.home.fragment.mine;

import lyl.weather.base.BaseControl;
import lyl.weather.control.MineControl;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;
import lyl.weather.utils.MyUtils;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class MinePresenterImpl implements MineControl.IMinePresenter {

    private MineControl.MineView mineView;
    private MineControl.IMineModel iMineModel;

    public MinePresenterImpl(MineControl.MineView mineView) {
        this.mineView = mineView;
        iMineModel = new MineModelImpl(this);
    }

    @Override
    public void getUserInfo() {
        iMineModel.getUserInfo(new BaseControl.IBaseModel.RequestListener<UserInfo>() {
            @Override
            public void success(UserInfo userInfo) {


                mineView.getUserInfo(userInfo);

            }

            @Override
            public void error() {
                mineView.showToast("查询失败");
            }
        });
    }

    @Override
    public void showLogoutDialog() {

    }


    @Override
    public void getVersionInfo() {
        mineView.showProgress("查询中");
        iMineModel.versionInfo(new BaseControl.IBaseModel.RequestListener<VersionInfo>() {
            @Override
            public void success(VersionInfo response) {
                //当前版本号
                int currentVersionCode = MyUtils.getAppVersionCode(mineView.getContexts());
                String versionCode = response.getVersion();
                String apkUrl = response.getApkUrl();
                if (Integer.parseInt(versionCode) > currentVersionCode) {

                    mineView.versionInfo(response);
                } else {
                   mineView.showToast("已经是最新版本");
                }
            }

            @Override
            public void error() {

            }
        });
    }

}

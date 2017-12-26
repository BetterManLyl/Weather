package lyl.weather.home.fragment.mine;

import android.content.Context;

import com.rn.base.utils.MyToast;

import lyl.weather.base.IBaseModel;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;
import lyl.weather.utils.MyUtils;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class MinePresenterImpl implements IMinePresenter {

    private MineView mineView;
    private IMineModel iMineModel;

    public MinePresenterImpl(MineView mineView) {
        this.mineView = mineView;
        iMineModel = new MineModelImpl(this);
    }

    @Override
    public void getUserInfo() {
        iMineModel.getUserInfo(new IBaseModel.RequestListener<UserInfo>() {
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
        iMineModel.versionInfo(new IBaseModel.RequestListener<VersionInfo>() {
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

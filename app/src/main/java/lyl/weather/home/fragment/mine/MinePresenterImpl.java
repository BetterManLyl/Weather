package lyl.weather.home.fragment.mine;

import lyl.weather.base.IBaseModel;
import lyl.weather.model.UserInfo;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class MinePresenterImpl implements IMinePresenter {

    private MineView mineView;
    private IMineModel iMineModel;

    public MinePresenterImpl(MineView mineView) {
        this.mineView = mineView;
        iMineModel = new MineModelImpl();
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
}

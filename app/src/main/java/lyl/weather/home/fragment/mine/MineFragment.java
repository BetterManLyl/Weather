package lyl.weather.home.fragment.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lyl.weather.R;
import lyl.weather.base.BaseFragment;
import lyl.weather.model.UserInfo;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class MineFragment extends BaseFragment implements MineView {


    @BindView(R.id.tv_mine_username)
    TextView tvMineUsername;
    @BindView(R.id.ll_modify_password)
    LinearLayout llModifyPassword;
    @BindView(R.id.ll_version_update)
    LinearLayout llVersionUpdate;
    @BindView(R.id.btn_logout)
    Button btnLogout;


    public static MineFragment newInstance() {
        MineFragment mineFragment = new MineFragment();
        Bundle bundle = new Bundle();
        mineFragment.setArguments(bundle);
        return mineFragment;
    }

    private IMinePresenter iMinePresenter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        iMinePresenter = new MinePresenterImpl(this);
        iMinePresenter.getUserInfo();
    }

    @Override
    public void getUserInfo(UserInfo userInfo) {
        tvMineUsername.setText(userInfo.getRealName());
    }

    @Override
    public void checkVersion() {

    }


    @OnClick({R.id.tv_mine_username, R.id.ll_modify_password, R.id.ll_version_update, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_username:
                break;
            case R.id.ll_modify_password:
                break;
            case R.id.ll_version_update:
                break;
            case R.id.btn_logout:
                break;
            default:
                break;
        }
    }
}

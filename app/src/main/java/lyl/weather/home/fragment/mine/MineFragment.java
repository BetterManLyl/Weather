package lyl.weather.home.fragment.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rn.base.utils.MyToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;
import lyl.weather.R;
import lyl.weather.base.BaseFragment;
import lyl.weather.event.VersionEvent;
import lyl.weather.home.activity.ModifyPasswordActivity;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;
import lyl.weather.utils.Constants;
import lyl.weather.utils.MyUtils;

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
    public void goActivity(Class c) {
        startActivity(new Intent(getActivity(), c));
    }

    @Override
    public void versionInfo(VersionInfo response) {
        hideProgerss();
        showToast("需要更新...");
    }

    @Override
    public Context getContexts() {
        return getActivity();
    }


    @OnClick({R.id.tv_mine_username, R.id.ll_modify_password, R.id.ll_version_update, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_username:
                break;
            case R.id.ll_modify_password:
                goActivity(ModifyPasswordActivity.class);
                break;
            case R.id.ll_version_update:
                showProgress("查询中");
                iMinePresenter.getVersionInfo();
                break;
            case R.id.btn_logout:
                //  iMinePresenter.showLogoutDialog();
                break;
            default:
                break;
        }
    }
}

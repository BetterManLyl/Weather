package lyl.weather.home.fragment.costprepay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lyl.weather.R;
import lyl.weather.base.BaseFragment;
import lyl.weather.home.fragment.costprepay.activity.ShangHuActivity;

/**
 * @author lyl
 * @date 2017/12/21.
 * 费用预缴
 */

public class CostPrepayFragment extends BaseFragment {
    @BindView(R.id.tv_cost_prepare_shanghu)
    TextView tvCostPrepareShanghu;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_left_money)
    TextView tvLeftMoney;
    @BindView(R.id.ll_prepare_tenant)
    LinearLayout llPrepareTenant;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.btn_next_step)
    Button btnNextStep;
    Unbinder unbinder;

    public static CostPrepayFragment newInstance() {
        CostPrepayFragment costPrepayFragment = new CostPrepayFragment();
        Bundle bundle = new Bundle();
        costPrepayFragment.setArguments(bundle);
        return costPrepayFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cost_prepare;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.tv_cost_prepare_shanghu, R.id.tv_message, R.id.tv_left_money,
            R.id.ll_prepare_tenant, R.id.ed_money, R.id.btn_next_step})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cost_prepare_shanghu:
                break;
            case R.id.tv_message:
                break;
            case R.id.tv_left_money:
                break;
            case R.id.ll_prepare_tenant:
                goActivity(ShangHuActivity.class);
                break;
            case R.id.ed_money:
                break;
            case R.id.btn_next_step:
                break;
            default:
                break;
        }
    }
}

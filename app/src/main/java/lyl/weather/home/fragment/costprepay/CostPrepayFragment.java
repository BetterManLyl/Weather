package lyl.weather.home.fragment.costprepay;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lyl.weather.R;
import lyl.weather.base.BaseFragment;
import lyl.weather.base.BaseView;
import lyl.weather.event.SearchEvent;
import lyl.weather.home.fragment.costprepay.activity.ShangHuActivity;

/**
 * @author lyl
 * @date 2017/12/21.
 * 费用预缴
 */

public class CostPrepayFragment extends BaseFragment implements CostPrepayView {
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
    private int id;

    private CostPrepayPresenter costPresenter;

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
        EventBus.getDefault().register(this);
        costPresenter = new CostPrepayPresenterImpl(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 选择完商户后的处理事件
     *
     * @param searchEvent
     */
    @Subscribe
    public void onEvent(SearchEvent searchEvent) {
        tvLeftMoney.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.VISIBLE);
        if (searchEvent.getMoney().contains("-")) {
            tvLeftMoney.setText(searchEvent.getMoney());
            //红色
            tvLeftMoney.setTextColor(Color.parseColor("#f76262"));
        } else {
            //绿色
            tvLeftMoney.setTextColor(Color.parseColor("#12db62"));
            if (searchEvent.getMoney().equals("0.00")) {
                tvLeftMoney.setText(searchEvent.getMoney());
            } else {
                tvLeftMoney.setText("+" + searchEvent.getMoney());
            }
        }
        tvCostPrepareShanghu.setText(searchEvent.getMessage());
        id = searchEvent.getId();
    }


    @OnClick({R.id.ll_prepare_tenant, R.id.ed_money, R.id.btn_next_step})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_prepare_tenant:
                goActivity(ShangHuActivity.class);
                break;
            case R.id.btn_next_step:
                nextStep();
                break;
            default:
                break;
        }
    }

    /**
     * 下一步
     */
    private void nextStep() {
        costPresenter.requestServer();
    }

    @Override
    public String getEd() {
        return edMoney.getText().toString();
    }
}

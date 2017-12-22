package lyl.weather.home.fragment.costprepay;

import android.os.Bundle;

import lyl.weather.R;
import lyl.weather.base.BaseFragment;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class CostPrepayFragment extends BaseFragment {
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
}

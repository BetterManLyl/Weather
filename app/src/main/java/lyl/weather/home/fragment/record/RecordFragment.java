package lyl.weather.home.fragment.record;

import android.os.Bundle;

import lyl.weather.R;
import lyl.weather.base.BaseFragment;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class RecordFragment extends BaseFragment {

    public static RecordFragment newInstance() {
        RecordFragment recordFragment = new RecordFragment();
        Bundle bundle = new Bundle();
        recordFragment.setArguments(bundle);
        return recordFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_prepare_record;
    }

    @Override
    public void initView() {

    }
}

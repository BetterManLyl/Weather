package lyl.weather.home.fragment.costprepay.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import lyl.weather.R;
import lyl.weather.adapter.ChooseMerchantsAdapter;
import lyl.weather.base.BaseActivity;
import lyl.weather.utils.MyUtils;

/**
 * @author lyl
 * @date 2017/12/26.
 */

public class ShangHuActivity extends BaseActivity implements ShanghuView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ed_search_merchants)
    EditText edSearchMerchants;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.ll_no_data)
    LinearLayout llNoData;

    private ChooseMerchantsAdapter chooseMerchantsAdapter;

    private ShanghuPresenter shanghuPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_choose_merchants;
    }

    @Override
    public void initView() {

        toolbarTitle.setText("选择商户");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //关闭键盘
                MyUtils.closeSysBoard(ShangHuActivity.this);
            }
        });
        shanghuPresenter = new ShanghuPresenterImpl(this);
        initData();
        initRecycler();
    }




    private void initRecycler() {
        LinearLayoutManager ll = new LinearLayoutManager(this);
        rvRecyclerView.setLayoutManager(ll);
        rvRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        chooseMerchantsAdapter=new ChooseMerchantsAdapter(shanghuPresenter.getList(),this);
        rvRecyclerView.setAdapter(chooseMerchantsAdapter);
    }

    private void initData() {
        shanghuPresenter.requestServer();
    }

    @Override
    public String getTrimStr() {
        return edSearchMerchants.getText().toString();
    }

    @Override
    public void notifychanged() {
        shanghuPresenter.getList();
        chooseMerchantsAdapter.notifyDataSetChanged();
    }
}

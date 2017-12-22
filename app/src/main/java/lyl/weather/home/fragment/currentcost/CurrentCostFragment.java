package lyl.weather.home.fragment.currentcost;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lyl.weather.R;
import lyl.weather.adapter.CurrentTimeCostAdapter;
import lyl.weather.base.BaseFragment;
import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;
import lyl.weather.utils.MyUtils;
import lyl.weather.view.DividerItemDecoration;
import lyl.weather.view.FullyLinearLayoutManager;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class CurrentCostFragment extends BaseFragment implements CurrentCostView {

    @BindView(R.id.ed_search_merchants)
    EditText edSearchMerchants;
    @BindView(R.id.tv_all_commercial_tenant)
    TextView tv_all_commercial_tenant;
    @BindView(R.id.tv_balance_deficiency)
    TextView tv_balance_deficiency;
    @BindView(R.id.tv_need_pay_user)
    TextView tv_need_pay_user;
    @BindView(R.id.tv_arrearage_money)
    TextView tv_arrearage_money;
    @BindView(R.id.tv_query_info)
    TextView tvQueryInfo;
    @BindView(R.id.rv_recycler_view1)
    RecyclerView rvRecyclerView1;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.ll_no_data)
    LinearLayout llNoData;

    private CurrentCostPresenter currentCostPresenter;


    private int pageSize = 20;
    private String term = "";
    private LinearLayoutManager linearLayoutManager;
    private CurrentTimeCostAdapter currentTimeCostAdapter;
    private List<CurrentCostDatas.DataBean> currentCostDatases = new ArrayList<>();

    public static CurrentCostFragment newInstance() {
        CurrentCostFragment currentCostFragment = new CurrentCostFragment();
        Bundle bundle = new Bundle();
        currentCostFragment.setArguments(bundle);
        return currentCostFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_current_time_cost;
    }

    @Override
    public void initView() {
        currentCostPresenter = new CurrentCostPresenterImpl(this);
        term = edSearchMerchants.getText().toString();
        initRecycler();
        recyclerRefresh();
        recyclerLoadMore();
    }

    /**
     * 下拉加载更多
     */
    private void recyclerLoadMore() {
        rvRecyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressWarnings("AlibabaAvoidCommentBehindStatement")
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if ((!isLoadMore) && (dy > 0)) {//没有在加载，向上滑动
                    int visible = linearLayoutManager.getChildCount();//可见 获取可见的Item的数量.
                    int first = linearLayoutManager.findFirstCompletelyVisibleItemPosition();//获取第一个完全可见Item的Position.
                    int total = linearLayoutManager.getItemCount();//总数 返回Adapter当前持有的Item的数量,等于List数据源的数目.
                    int nowLast = visible + first;
                    if (nowLast > total) {
                        isLoadMore = true;
                        queryData();
                    }
                }
            }
        });
    }

    /**
     * 刷新
     */
    private void recyclerRefresh() {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
    }

    /**
     * 下拉刷新
     */
    private void refreshData() {
        isLoadMore = false;
        pageIndex = 1;
        currentCostDatases.clear();
        //下拉刷新的时候  加上这句 防止在刷新的过程中出现 上滑动作 导致崩溃
        currentTimeCostAdapter.notifyDataSetChanged();
        currentTimeCostAdapter.initMap();
        queryData();
    }

    @Override
    public void queryData() {
        super.queryData();
        //  currentCostDatases.clear();
        currentCostPresenter.initData();
        currentCostPresenter.initDataList(term, pageIndex, pageSize, currentCostDatases);

    }

    private void initRecycler() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //  rvRecyclerView1.setNestedScrollingEnabled(false);
        rvRecyclerView1.setLayoutManager(linearLayoutManager);
        //添加分割线
        rvRecyclerView1.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        currentTimeCostAdapter = new CurrentTimeCostAdapter(getActivity(), currentCostDatases);
        rvRecyclerView1.setAdapter(currentTimeCostAdapter);
    }

    @Override
    public void initData(CurrentCost response) {
        tv_all_commercial_tenant.setText(response.getTotalCustomers());
        tv_balance_deficiency.setText(response.getLowBalanceCustomers());
        tv_need_pay_user.setText(response.getPayRequiredCustomers());
        tv_arrearage_money.setText(response.getArrearsTotalAmount());
    }

    @Override
    public void initDataList(CurrentCostDatas currentCostDatas) {
        if (pageIndex == 1) {
            currentCostDatases.clear();
        }
        currentCostDatases.addAll(currentCostDatas.getData());
        currentTimeCostAdapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
        pageIndex++;
    }

    /**
     * 数据已经加载完毕
     */
    @Override
    public void noDates() {
        showToast("已经到底了");
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}

package lyl.weather.home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lyl.weather.R;
import lyl.weather.base.BaseActivity;
import lyl.weather.home.fragment.costprepay.CostPrepayFragment;
import lyl.weather.home.fragment.currentcost.CurrentCostFragment;
import lyl.weather.home.fragment.mine.MineFragment;
import lyl.weather.home.fragment.record.RecordFragment;
import lyl.weather.utils.Constants;
import lyl.weather.utils.MyUtils;
import lyl.weather.view.MyViewPager;

import static lyl.weather.utils.Constants.MENU_COST_PREPARE;
import static lyl.weather.utils.Constants.MENU_CURRNT_COST;
import static lyl.weather.utils.Constants.MENU_PREPAER_RECORD;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class HomeActivity extends BaseActivity implements HomeView {
    @BindView(R.id.toolbar_title)
    TextView toolBarTitle;
    @BindView(R.id.toolbar)
    Toolbar tab_layout;
    @BindView(R.id.vp_viewpager)
    MyViewPager vp_pager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private HomePresenter homePresenter;
    private Context context;

    private TabAdapter tabAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    //用户最后一次点击的菜单
    public int TAB_POSITION = -1;

    private String[] titles = new String[]{};

    @Override
    public int layoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void initView() {

        homePresenter = new HomePresenterImpl(this);
        homePresenter.initMenu();
        homePresenter.init();
        homePresenter.saveUserinfo();
        setInitTabMenu();
        tabSelectedListener();
    }

    /**
     * @param title toolbar标题
     */
    private void setToolbarTitle(String title) {
        if (toolBarTitle == null) {
            toolBarTitle = (TextView) findViewById(R.id.toolbar_title);
        }
        toolBarTitle.setText(title);
    }

    private void tabSelectedListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TAB_POSITION = tab.getPosition();
                vp_pager.setCurrentItem(TAB_POSITION);
                setToolbarTitle(titles[TAB_POSITION]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int i = 0;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int i = 0;
            }
        });
    }

    /**
     * 设置初始显示页
     */
    private void setInitTabMenu() {
        if (TAB_POSITION == 0 && tabLayout.getTabCount() > 1) {
            tabLayout.getTabAt(1).select();
        }
        if (TAB_POSITION == -1) {
            TAB_POSITION = 0;
        }
        if (TAB_POSITION == 0 && tabLayout.getTabCount() > 1) {
            //不然会没有颜色显示
            tabLayout.getTabAt(1).select();
        }
        tabLayout.getTabAt(TAB_POSITION).select();
        setToolbarTitle(titles[TAB_POSITION]);
    }

    /**
     * @param title tab标题
     * @return tab的自定义view
     */
    private View getTabViewByTitle(String title) {
        View view = getLayoutInflater().inflate(R.layout.ac_tab_home, null);
        ((TextView) view.findViewById(R.id.tv)).setText(title);

        if (title.equals(MENU_CURRNT_COST)) {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.click_tab_current_time_cost);
        } else if (title.equals(MENU_COST_PREPARE)) {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.click_tab_cost_prepay);
        } else if (title.equals(MENU_PREPAER_RECORD)) {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.click_tab_cost_record);
        } else if (title.equals(Constants.MENU_MINE)) {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.click_tab_mine);
        }
        return view;
    }

    @Override
    public void init(String[] titles, boolean isHasmenu) {
        ArrayList<View> views = new ArrayList<View>();
        if (isHasmenu) {
            fragments.add(CurrentCostFragment.newInstance());
            fragments.add(CostPrepayFragment.newInstance());

            fragments.add(RecordFragment.newInstance());
            fragments.add(MineFragment.newInstance());
            views.add(getTabViewByTitle(MENU_CURRNT_COST));
            views.add(getTabViewByTitle(MENU_COST_PREPARE));
            views.add(getTabViewByTitle(MENU_PREPAER_RECORD));
            views.add(getTabViewByTitle(Constants.MENU_MINE));
            titles = new String[]{MENU_CURRNT_COST, MENU_COST_PREPARE, MENU_PREPAER_RECORD, Constants.MENU_MINE};
            this.titles = titles;
        } else {

            fragments.add(CurrentCostFragment.newInstance());
            fragments.add(RecordFragment.newInstance());
            fragments.add(MineFragment.newInstance());
            views.add(getTabViewByTitle(MENU_CURRNT_COST));
            views.add(getTabViewByTitle(MENU_PREPAER_RECORD));
            views.add(getTabViewByTitle(Constants.MENU_MINE));
            titles = new String[]{MENU_CURRNT_COST, MENU_PREPAER_RECORD, Constants.MENU_MINE};
            this.titles = titles;
        }
        tabAdapter = new TabAdapter(getSupportFragmentManager(), titles, fragments);
        vp_pager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(vp_pager);
        vp_pager.setCurrentItem(0);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //自定义tab
        for (int i = 0, count = tabLayout.getTabCount(); i < count; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(views.get(i));
        }

    }
}

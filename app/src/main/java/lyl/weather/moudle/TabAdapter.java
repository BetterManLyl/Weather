package lyl.weather.moudle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private String[]titles;

    public TabAdapter(FragmentManager fm, String[]titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments=fragments;
    }
    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
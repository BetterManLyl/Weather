package lyl.weather.home;

import lyl.weather.control.HomeControl;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class HomePresenterImpl implements HomeControl.HomePresenter {

    private HomeControl.HomeView homeView;
    private HomeControl.IHomeModel iHomeModel;

    public HomePresenterImpl(HomeControl.HomeView homeView) {
        this.homeView = homeView;
        iHomeModel = new IHomeModelImpl();
    }


    @Override
    public void init() {
        iHomeModel.upDataVersion();
    }

    @Override
    public void initMenu() {
        iHomeModel.getMenu(new HomeControl.IHomeModel.GetMenuListener() {
            @Override
            public void has() {
                homeView.init(getTitles(), true);
            }

            @Override
            public void notHas() {
                homeView.init(getTitles(), false);
            }
        });
    }


    @Override
    public String[] getTitles() {
        return iHomeModel.getTitles();
    }

    @Override
    public void saveUserinfo() {
        iHomeModel.saveUserinfo();
    }
}

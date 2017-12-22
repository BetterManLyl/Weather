package lyl.weather.home;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;
    private IHomeModel iHomeModel;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        iHomeModel = new IHomeModelImpl();
    }


    @Override
    public void init() {
        iHomeModel.upDataVersion();
    }

    @Override
    public void initMenu() {
        iHomeModel.getMenu(new IHomeModel.GetMenuListener() {
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

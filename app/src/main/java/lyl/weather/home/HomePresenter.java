package lyl.weather.home;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface HomePresenter {
    void init();

    void initMenu();

    String[] getTitles();

    void  saveUserinfo();
}

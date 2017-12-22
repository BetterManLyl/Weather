package lyl.weather.welcome;

import lyl.weather.base.BaseView;

/**
 * @author lyl
 * @date 2017/12/20.
 * 接口继承抽象类
 */

public interface WelcomeView extends BaseView{


    void showView();

    /**
     * 跳转
     */
    void goActivity(Class t);


}

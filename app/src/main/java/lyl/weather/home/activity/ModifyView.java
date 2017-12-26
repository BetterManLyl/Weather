package lyl.weather.home.activity;

import lyl.weather.base.BaseView;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public interface ModifyView extends BaseView{


    String getOldPass();

    String getNewPass();

    String getConfirmPass();

    void showSuccessPop();
}

package lyl.weather.home.activity;

import java.util.HashMap;

import lyl.weather.api.ModifyPass;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public interface IModifyPresenter {

    void modifyPassword();

    ModifyPass getModifyPass();

    boolean filter();
}

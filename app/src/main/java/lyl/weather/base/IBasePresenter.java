package lyl.weather.base;

import android.content.Context;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public interface IBasePresenter {


    void requestServer();

    Context getContext();
}

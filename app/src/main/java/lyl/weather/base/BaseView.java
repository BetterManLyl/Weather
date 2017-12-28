package lyl.weather.base;

import android.content.Context;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public interface BaseView {
    /**
     * toast
     *
     * @param message
     */
    void showToast(String message);

    /**
     * 显示dialog
     *
     * @param message
     */
    void showProgress(String message);

    /**
     * 隐藏dialog
     */
    void hideProgerss();

    /**
     * 返回context
     *
     * @return
     */
    Context getContext();

}

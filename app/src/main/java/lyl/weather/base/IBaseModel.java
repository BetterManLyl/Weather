package lyl.weather.base;

import java.util.HashMap;

/**
 * @author lyl
 * @date 2017/12/22.
 * Model接口基类
 */

public interface IBaseModel<T>{

    /**
     *
     * @param requestListener
     * @param
     */
    void requestServer(RequestListener requestListener);

    /**
     *
     */
    void cancelRequest();


    /**
     *
     * @param <T>
     */
    interface RequestListener<T> {
        void success(T t);

        void error();
    }
}

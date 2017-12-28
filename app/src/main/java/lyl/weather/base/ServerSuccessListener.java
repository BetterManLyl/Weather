package lyl.weather.base;

/**
 * @author lyl
 * @date 2017/12/27.
 * 网络请求成功返回
 */

public interface ServerSuccessListener<T> {
    void success(T t);

    void error(String message);
}

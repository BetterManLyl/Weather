package lyl.weather.rxutil;

/**
 * @author lyl
 * @date 2017/11/27.
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);

    void onError(int code, String message);
}

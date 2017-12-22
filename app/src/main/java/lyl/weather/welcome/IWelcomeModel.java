package lyl.weather.welcome;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public interface IWelcomeModel {

    void login(String userName, String userPass,OnLoginListener onLoginListener);

    void getMenu(OnLoginListener onLoginListener);

    interface OnLoginListener {
        void success(String message);

        void error(String message);

    }
}

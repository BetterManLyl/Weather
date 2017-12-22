package lyl.weather.welcome;

import com.rn.base.user.LocalCfg;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public interface WelcomePresenter {

    /**
     * 自动登录
     */
    void selfLogin(LocalCfg localCfg);


    /**
     * 保存个人信息
     */
    void saveUserInfo();



}

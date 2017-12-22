package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/6/3.
 *
 * 登录
 */

public class LoginSucess implements Serializable {


    private boolean result;
    private String message;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

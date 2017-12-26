package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/5/25.
 * 修改密码
 */

public class ModifyPassword implements Serializable {

    private boolean result;
    private String message;

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

    @Override
    public String toString() {
        return "ModifyPassword{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}

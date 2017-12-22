package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/5/24.
 *
 * 结果处理
 */

public class ResultInfo implements Serializable {

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
}

package lyl.weather.model;

/**
 * @author lyl
 * @date 2017/11/20.
 */

public class Logout {


    /**
     * result : true
     * message : 退出成功
     */

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

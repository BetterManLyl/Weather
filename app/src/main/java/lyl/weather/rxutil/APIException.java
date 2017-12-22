package lyl.weather.rxutil;

/**
 * @author lyl
 * @date 2017/11/27.
 */

public class APIException extends RuntimeException {
    public int code;
    public String message;

    public APIException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}

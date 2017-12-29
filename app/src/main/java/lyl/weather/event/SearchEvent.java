package lyl.weather.event;

/**
 * Created by lyl on 2017/5/23.
 * <p>
 * 商户完后的事件发送
 */

public class SearchEvent {
    private String message;
    private String money;
    private int id;

    public int getId() {
        return id;
    }

    public String getMoney() {
        return money;
    }


    public String getMessage() {
        return message;
    }


    public SearchEvent(String message, String money, int id) {
        this.message = message;
        this.money = money;
        this.id=id;
    }
}

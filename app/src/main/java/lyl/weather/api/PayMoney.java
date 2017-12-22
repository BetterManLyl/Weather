package lyl.weather.api;

/**
 * @author lyl
 * @date 2017/11/23.
 */

public class PayMoney {
    private String amount;

    public PayMoney(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

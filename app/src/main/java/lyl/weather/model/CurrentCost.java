package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/6/1.
 * <p>
 * 实时费用
 */

public class CurrentCost implements Serializable {

    //{"totalCustomers":"7","lowBalanceCustomers":"0.00","payRequiredCustomers":"7","arrearsTotalAmount":"7"}
    private String totalCustomers;//总商户
    private String lowBalanceCustomers; //余额不足商户
    private String payRequiredCustomers; //需缴费商户
    private String arrearsTotalAmount; //欠费总金额


    public String getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(String totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public String getLowBalanceCustomers() {
        return lowBalanceCustomers;
    }

    public void setLowBalanceCustomers(String lowBalanceCustomers) {
        this.lowBalanceCustomers = lowBalanceCustomers;
    }

    public String getPayRequiredCustomers() {
        return payRequiredCustomers;
    }

    public void setPayRequiredCustomers(String payRequiredCustomers) {
        this.payRequiredCustomers = payRequiredCustomers;
    }

    public String getArrearsTotalAmount() {
        return arrearsTotalAmount;
    }

    public void setArrearsTotalAmount(String arrearsTotalAmount) {
        this.arrearsTotalAmount = arrearsTotalAmount;
    }

    @Override
    public String toString() {
        return "CurrentCost{" +
                "totalCustomers='" + totalCustomers + '\'' +
                ", lowBalanceCustomers='" + lowBalanceCustomers + '\'' +
                ", payRequiredCustomers='" + payRequiredCustomers + '\'' +
                ", arrearsTotalAmount='" + arrearsTotalAmount + '\'' +
                '}';
    }
}

package lyl.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyl on 2017/6/5.
 * 实时数据分页数据
 */

public class CurrentCostDatas implements Serializable {


    /**
     * total : 9
     * pageCount : 1
     * pageIndex : 1
     * pageSize : 20
     * data : [{"uniqueId":14,"name":"测试dp11","houseNum":"1111111111","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"0.00","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":13,"name":"aaaaaaa","houseNum":"aaaaaa","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"0.00","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":12,"name":"dfdfdfd","houseNum":"dfdfdf","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"123.00","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":11,"name":"测试商户1234","houseNum":"hh122222","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"11.11","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":10,"name":"ddddddd","houseNum":"dddd","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"0.00","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":9,"name":"ddddddddd","houseNum":"ddddddd","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"99.10","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":8,"name":"aaaaaaaaaaaaaaaa","houseNum":"aaaaaaaaaaaaaaaa","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"0.00","balanceStatus":"余额不足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":7,"name":"xxxxxxx","houseNum":"aaaaaaaaaaaaa","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"1488.00","balanceStatus":"余额充足","status":false,"alermInfo":"连续上报异常"},{"uniqueId":6,"name":"我是商户1号","houseNum":"111111","useFlow":"--","monthFlow":"0.00","deductionAmount":"--","actualBalance":"5167.23","balanceStatus":"余额充足","status":false,"alermInfo":"连续上报异常"}]
     * sortName : null
     * sortType : null
     * firstResults : 0
     */

    private int total;
    private int pageCount;
    private int pageIndex;
    private int pageSize;
    private Object sortName;
    private Object sortType;
    private int firstResults;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Object getSortName() {
        return sortName;
    }

    public void setSortName(Object sortName) {
        this.sortName = sortName;
    }

    public Object getSortType() {
        return sortType;
    }

    public void setSortType(Object sortType) {
        this.sortType = sortType;
    }

    public int getFirstResults() {
        return firstResults;
    }

    public void setFirstResults(int firstResults) {
        this.firstResults = firstResults;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uniqueId : 14
         * name : 测试dp11
         * houseNum : 1111111111
         * useFlow : --
         * monthFlow : 0.00
         * deductionAmount : --
         * actualBalance : 0.00
         * balanceStatus : 余额不足
         * status : false
         * alermInfo : 连续上报异常
         */

        private int uniqueId;
        private String name;
        private String houseNum;
        private String useFlow;
        private String monthFlow;
        private String deductionAmount;
        private String actualBalance;
        private String balanceStatus;
        private boolean status;
        private String alermInfo;

        public int getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(int uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHouseNum() {
            return houseNum;
        }

        public void setHouseNum(String houseNum) {
            this.houseNum = houseNum;
        }

        public String getUseFlow() {
            return useFlow;
        }

        public void setUseFlow(String useFlow) {
            this.useFlow = useFlow;
        }

        public String getMonthFlow() {
            return monthFlow;
        }

        public void setMonthFlow(String monthFlow) {
            this.monthFlow = monthFlow;
        }

        public String getDeductionAmount() {
            return deductionAmount;
        }

        public void setDeductionAmount(String deductionAmount) {
            this.deductionAmount = deductionAmount;
        }

        public String getActualBalance() {
            return actualBalance;
        }

        public void setActualBalance(String actualBalance) {
            this.actualBalance = actualBalance;
        }

        public String getBalanceStatus() {
            return balanceStatus;
        }

        public void setBalanceStatus(String balanceStatus) {
            this.balanceStatus = balanceStatus;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getAlermInfo() {
            return alermInfo;
        }

        public void setAlermInfo(String alermInfo) {
            this.alermInfo = alermInfo;
        }
    }
}

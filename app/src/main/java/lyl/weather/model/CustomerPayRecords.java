package lyl.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyl on 2017/6/5.
 *
 * 预缴记录
 */

public class CustomerPayRecords implements Serializable {


    /**
     * total : 2
     * pageCount : 1
     * pageIndex : 1
     * pageSize : 2
     * data : [{"uniqueId":6,"name":"我是商户1号","houseNum":"111111","billingTime":"2017-06-05 11:50:15","amount":"1200.00"},{"uniqueId":6,"name":"我是商户1号","houseNum":"111111","billingTime":"2017-06-05 11:45:55","amount":"2300.23"}]
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
         * uniqueId : 6
         * name : 我是商户1号
         * houseNum : 111111
         * billingTime : 2017-06-05 11:50:15
         * amount : 1200.00
         */

        private int uniqueId;
        private String name;
        private String houseNum;
        private String billingTime;
        private String amount;

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

        public String getBillingTime() {
            return billingTime;
        }

        public void setBillingTime(String billingTime) {
            this.billingTime = billingTime;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}

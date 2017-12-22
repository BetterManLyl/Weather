package lyl.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyl on 2017/6/5.
 * <p>
 * 商户
 */

public class Customers implements Serializable {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uniqueId : 5
         * name : 丁丁
         * actualBalance : 0.00
         */

        private int uniqueId;
        private String name;
        private String actualBalance;

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

        public String getActualBalance() {
            return actualBalance;
        }

        public void setActualBalance(String actualBalance) {
            this.actualBalance = actualBalance;
        }
    }
}

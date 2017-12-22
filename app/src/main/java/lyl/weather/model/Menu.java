package lyl.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyl on 2017/6/6.
 *菜单
*/

public class Menu implements Serializable {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uniqueId : 15
         * pid : null
         * text : PrepaidExpense
         * sref : null
         * icon : icon-wallet
         * translate : sidebar.nav.PREPAID_EXPENSE
         * submenu : []
         */

        private int uniqueId;
        private Object pid;
        private String text;
        private Object sref;
        private String icon;
        private String translate;
        private List<?> submenu;

        public int getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(int uniqueId) {
            this.uniqueId = uniqueId;
        }

        public Object getPid() {
            return pid;
        }

        public void setPid(Object pid) {
            this.pid = pid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Object getSref() {
            return sref;
        }

        public void setSref(Object sref) {
            this.sref = sref;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTranslate() {
            return translate;
        }

        public void setTranslate(String translate) {
            this.translate = translate;
        }

        public List<?> getSubmenu() {
            return submenu;
        }

        public void setSubmenu(List<?> submenu) {
            this.submenu = submenu;
        }
    }
}

package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/5/23.
 * 用户信息
 */

public class UserInfo implements Serializable {

    /**
     * uniqueId : 9
     * loginName : huxuan
     * realName : huxuan
     * cellphone : 11111111111
     * telephone : null
     * email : null
     * role : {"uniqueId":20,"name":"高级员工"}
     * status : true
     */

    private int uniqueId;
    private String loginName;
    private String realName;
    private String cellphone;
    private String telephone;
    private String email;
    private RoleBean role;
    private boolean status;

    public UserInfo() {
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public static class RoleBean {
        /**
         * uniqueId : 20
         * name : 高级员工
         */

        private int uniqueId;
        private String name;

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
    }
}

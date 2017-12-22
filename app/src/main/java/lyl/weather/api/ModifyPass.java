package lyl.weather.api;

/**
 * @author lyl
 * @date 2017/11/23.
 */

public class ModifyPass {
    private String oldPassword;
    private String password;

    public ModifyPass(String oldPassword, String password) {
        this.oldPassword = oldPassword;
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

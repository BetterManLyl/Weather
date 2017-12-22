package lyl.weather.model;

import java.io.Serializable;

/**
 * Created by lyl on 2017/5/25.
 * <p>
 * 版本信息
 */

public class VersionInfo implements Serializable {
    private String version;
    private String message;
    private String apkUrl;
    private String versionName;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }
}

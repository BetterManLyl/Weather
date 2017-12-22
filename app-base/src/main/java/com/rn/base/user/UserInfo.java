package com.rn.base.user;

/**
 * Created by Isay on 2016/8/9.
 * <p/>
 * 系统测试	  36.7.144.130:8088
 * 测试服务    36.7.144.130:8088/wisdomweb1
 * 瑞纳金科    123.57.172.9:2401
 * 新疆安耐洁  117.190.224.66:11002
 */
public class UserInfo {

    private static UserInfo instance;
    //是否使用测试服务器地址  false：不使用   true：使用
    public static boolean isUseTestInterface = false;
    //测试服务器地址
    public static final String TEST_INTERFACE = "199.28.0.221:8888";

    //总公司名
    public String HEAD_COMPANY;
    //真实姓名
    public String REAL_NAME;
    //登陆账号
    public String USER_NAME;
    //用户ID
    public String USER_ID;
    //用戶菜单
    public String USER_MENU;
    //服务器地址
    public String USER_SERVER_ADDRESS;
    //Token值
    public String USER_TOKEN;
    //uuid值
    public String SERVER_UUID;

    //用户最后一次点击的菜单页面
    public int LAST_HOME_POSITOIN = -1;
    public int LAST_WORKSHEET_POSITOIN = -1;


    /**
     * 定义私有的构造函数，防止外部通过new UserInfo()进行实例化
     */
    private UserInfo() {

    }

    /**
     * @return UserInfo单例
     */
    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }


    /**
     * UserInfo还原用户信息
     */
    public static void initInstance() {
        if (instance != null) {
            instance.HEAD_COMPANY = null;
            instance.REAL_NAME = null;
            instance.USER_NAME = null;
            instance.USER_ID = null;
            instance.USER_MENU = null;
            instance.LAST_HOME_POSITOIN = -1;
            instance.LAST_WORKSHEET_POSITOIN = -1;
        }
    }

    /**
     * @return 服务器地址
     */
    public String getUserServerAddress() {
        //是否使用测试地址
        if (isUseTestInterface) {
            return TEST_INTERFACE;
        } else {
            if (USER_SERVER_ADDRESS == null) {
                //读取保存的服务器地址
                USER_SERVER_ADDRESS = new LocalCfg().readCfgStr("my_address");
            }
        }

        return USER_SERVER_ADDRESS;
    }

    /**
     * @return 服务器地址
     */
    public String getToken() {
        if (USER_TOKEN == null) {
            USER_TOKEN = new LocalCfg().readCfgStr("user_token");
        }
        return USER_TOKEN;
    }

    /**
     * @return 服务器UUID值
     */
    public String getServerUuid() {
        if (SERVER_UUID == null) {
            SERVER_UUID = new LocalCfg().readCfgStr("server_uuid");
        }
        return SERVER_UUID;
    }


    /**
     * @return 真实姓名
     */
    public String getRealName() {
        if (REAL_NAME == null) {
            REAL_NAME = new LocalCfg().readCfgStr("real_name");
        }
        return REAL_NAME;
    }

    /**
     * @return 用户id
     */
    public String getUserId() {
        if (USER_ID == null) {
            USER_ID = new LocalCfg().readCfgStr("user_id");
        }
        return USER_ID;
    }


    /**
     * @return 登录名
     */
    public String getUserName() {
        if (USER_NAME == null) {
            USER_NAME = new LocalCfg().readCfgStr("login_name");
        }
        return USER_NAME;
    }

    /**
     * @return 菜单
     */
    public String getHeadCompany() {
        if (HEAD_COMPANY == null) {
            HEAD_COMPANY = new LocalCfg().readCfgStr("head_company");
        }
        return HEAD_COMPANY;
    }

    /**
     * @return 菜单
     */
    public String getUserMenu() {
        if (USER_MENU == null) {
            USER_MENU = new LocalCfg().readCfgStr("menu_prepay_cost");
        }
        return USER_MENU;
    }

    /**
     * @return 获取用户最后点击的菜单
     */
    public int getHomeTabPosition() {
        if (LAST_HOME_POSITOIN == -1) {
            LAST_HOME_POSITOIN = new LocalCfg().readCfgInt("home_tab_position");
        }
        return LAST_HOME_POSITOIN;
    }

    /**
     * @return 设置用户最后点击的菜单
     */
    public void setHomeTabPosition(int last) {
        LAST_HOME_POSITOIN = last;
        new LocalCfg().writeCfg("home_tab_position", last);
    }


    /**
     * @return 获取用户最后点击的菜单
     */
    public int getWorkSheetTabPosition() {
        if (LAST_WORKSHEET_POSITOIN == -1) {
            LAST_WORKSHEET_POSITOIN = new LocalCfg().readCfgInt("worksheet_tab_position");
        }
        return LAST_WORKSHEET_POSITOIN;
    }

    /**
     * @return 设置用户最后点击的菜单
     */
    public void setWorkSheetTabPosition(int last) {
        LAST_WORKSHEET_POSITOIN = last;
        new LocalCfg().writeCfg("worksheet_tab_position", last);
    }


    /**
     * 登录结果
     */
    public void saveLoginUserInfo(String token, String loginName, String loginPass) {
        instance.USER_TOKEN = token;
        //2用户信息保存到本地
        LocalCfg localCfg = new LocalCfg();
        localCfg.writeCfg("login_name", loginName);
        localCfg.writeCfg("login_pass", loginPass);
        localCfg.writeCfg("user_token", instance.USER_TOKEN);
    }

    public void saveMenu(String menu){
        //2用户信息保存到本地
        LocalCfg localCfg = new LocalCfg();
        localCfg.writeCfg("menu_prepay_cost", menu);
    }
}

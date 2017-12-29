package lyl.weather.home;

import com.rn.base.user.LocalCfg;
import com.rn.base.user.UserInfo;

import lyl.weather.api.RetrofitUtil;
import lyl.weather.control.HomeControl;
import lyl.weather.utils.MyUtils;
import rx.Subscriber;

/**
 * @author lyl
 * @date 2017/12/21.
 */

public class IHomeModelImpl implements HomeControl.IHomeModel {

    private boolean isHas = false;
    private LocalCfg localCfg = new LocalCfg();

    @Override
    public void getMenu(GetMenuListener getMenuListener) {
        /**
         * 判断是否有费用预缴功能
         */
        if (UserInfo.getInstance().getUserMenu().equals("费用预缴")) {
            getMenuListener.has();
            isHas = true;

        } else {
            isHas = false;
            getMenuListener.notHas();
        }
    }

    public static final String MENU_CURRNT_COST = "实时费用";
    public static final String MENU_COST_PREPARE = "费用预缴";
    public static final String MENU_PREPAER_RECORD = "预缴记录";
    public static final String MENU_MINE = "我的";

    @Override
    public String[] getTitles() {
        if (isHas) {
            return new String[]{MENU_CURRNT_COST, MENU_COST_PREPARE, MENU_PREPAER_RECORD, MENU_MINE};
        } else {
            return new String[]{MENU_CURRNT_COST, MENU_PREPAER_RECORD, MENU_MINE};
        }
    }

    @Override
    public void saveUserinfo() {
        RetrofitUtil.getInstance().getUserinfo(new Subscriber<lyl.weather.model.UserInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                MyUtils.loge("获取个人信息失败");
            }

            @Override
            public void onNext(lyl.weather.model.UserInfo response) {
                localCfg.writeCfg("real_name", response.getRealName());
                localCfg.writeCfg("user_id", response.getUniqueId());
            }
        });
    }

    @Override
    public void upDataVersion() {

    }
}

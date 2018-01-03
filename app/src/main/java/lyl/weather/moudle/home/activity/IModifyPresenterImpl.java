package lyl.weather.moudle.home.activity;

import android.text.TextUtils;

import lyl.weather.control.CurrentCostControl;
import lyl.weather.control.ModifyControl;
import lyl.weather.model.ModifyPassword;
import lyl.weather.utils.MyUtils;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public class IModifyPresenterImpl implements ModifyControl.IModifyPresenter {

    private ModifyControl.ModifyView modifyView;
    private ModifyControl.IModifyModel iModifyModel;

    public IModifyPresenterImpl(ModifyControl.ModifyView modifyView) {
        this.modifyView = modifyView;
        iModifyModel = new IModifyModelImpl(this);
    }

    @Override
    public void modifyPassword() {
        iModifyModel.modifyPass(new CurrentCostControl.ICurrentModel.GetSuccess<ModifyPassword>() {
            @Override
            public void success(ModifyPassword modifyPass) {
                modifyView.hideProgerss();
                modifyView.showToast(modifyPass.getMessage());
                //密码修改成功
                if (modifyPass.isResult()){
                    modifyView.showSuccessPop();
                }
            }

            @Override
            public void error() {
                modifyView.showToast("修改密码失败");
                modifyView.hideProgerss();
            }

            @Override
            public void noDatas() {

            }
        });
    }

    @Override
    public lyl.weather.api.ModifyPass getModifyPass() {
        String oldPass = MyUtils.getMD5(modifyView.getOldPass());
        String newPass = MyUtils.getMD5(modifyView.getNewPass());
        lyl.weather.api.ModifyPass modifyPass = new lyl.weather.api.ModifyPass(oldPass, newPass);
        return modifyPass;
    }

    @Override
    public boolean filter() {
        if (TextUtils.isEmpty(modifyView.getNewPass())) {
            modifyView.showToast("请填写旧密码");
            return false;
        }
        if (TextUtils.isEmpty(modifyView.getNewPass())) {
            modifyView.showToast("请填写新密码");
            return false;
        }

        if (TextUtils.isEmpty(modifyView.getConfirmPass())) {
            modifyView.showToast("请填写确认密码");
            return false;
        }

        if (!modifyView.getNewPass().equals(modifyView.getConfirmPass())) {
            modifyView.showToast("两次密码不一致");
            return false;
        }
        return true;
    }
}

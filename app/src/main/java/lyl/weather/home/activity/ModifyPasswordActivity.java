package lyl.weather.home.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import lyl.weather.R;
import lyl.weather.base.BaseActivity;
import lyl.weather.utils.Constants;
import lyl.weather.utils.MyUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * @author lyl
 * @date 2017/12/25.
 */

public class ModifyPasswordActivity extends BaseActivity implements ModifyView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.ed_old_password)
    EditText edOldPassword;
    @BindView(R.id.ed_new_password)
    EditText edNewPassword;
    @BindView(R.id.ed_confirm_password)
    EditText edConfirmPassword;
    @BindView(R.id.btn_modify_pass_submit)
    Button btnModifyPassSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private IModifyPresenter iModifyPresenter;


    @Override
    public int layoutId() {
        return R.layout.activity_modify;
    }

    @Override
    public void initView() {
        toolbarTitle.setText("修改密码");
        iModifyPresenter = new IModifyPresenterImpl(this);
     //   setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RxView.clicks(btnModifyPassSubmit)
                .throttleFirst(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        if (iModifyPresenter.filter()) {
                            showProgress("修改中...");
                            iModifyPresenter.modifyPassword();
                        }
                    }
                });
    }

    @Override
    public String getOldPass() {
        return edOldPassword.getText().toString();
    }

    @Override
    public String getNewPass() {
        return edNewPassword.getText().toString();
    }

    @Override
    public String getConfirmPass() {
        return edConfirmPassword.getText().toString();
    }

    @Override
    public void showSuccessPop() {
        MyUtils.closeSysBoard(this);
        showPop(Constants.MODIFI_SUCCESS_TITLE, Constants.MODIFY_SUCCESS_MESSAGE, Constants.MODIFY_SUCCESS_MESSGE_TWO, 0);
    }
}

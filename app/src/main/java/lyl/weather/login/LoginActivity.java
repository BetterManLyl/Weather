package lyl.weather.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import lyl.weather.R;
import lyl.weather.base.BaseActivity;

/**
 * @author lyl
 * @date 2017/12/20.
 * 登录
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.ed_user_name)
    EditText edUserName;
    @BindView(R.id.ed_user_pass)
    EditText edUserPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.content)
    LinearLayout content;

    private LoginPresenter loginPresenter;


    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        loginPresenter = new LoginPresenterImpl(LoginActivity.this, this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginPresenter.login(edUserName.getText().toString(), edUserPass.getText().toString());
    }

    @Override
    public String getUserName() {
        return edUserName.getText().toString();
    }

    @Override
    public String getUserPass() {
        return edUserPass.getText().toString();
    }

    @Override
    public void filter(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goActivity(Class c) {
        startActivity(new Intent(this, c));
        finish();
    }

    @Override
    public void initEd(String userName,String userPass) {
        edUserName.setText(userName);
        edUserPass.setText(userPass);
    }

    @Override
    public void loginSuccess() {

    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

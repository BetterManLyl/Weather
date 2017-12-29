package lyl.weather.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lyl
 * @date 2017/12/20.
 */

public abstract class BaseFragment extends Fragment implements BaseControl.BaseView {

    private Unbinder unbinder;
    public boolean isUIVisible = false;
    private boolean isCreated = false;
    public int pageIndex = 1;
    public boolean isLoadMore = false;

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void goActivity(Class c) {
        startActivity(new Intent(getActivity(), c));
    }

    public Context getContexts() {
        return this.getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isCreated = true;
        lazyLoad();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void showProgress(String message) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void hideProgerss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,
        // 必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isCreated && isUIVisible) {
            pageIndex = 1;
            isLoadMore = false;
            queryData();
            //数据加载完毕,恢复标记,防止重复加载
            //isViewCreated = false;  根据需求需要，是否只有在销毁之后才会重新加载，还是每次可见都重新加载
            // 注释的话就是每次可见都加载
            //isCreated = false;
            isUIVisible = false;
        }
    }

    public void queryData() {

    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //页面销毁,恢复标记
        isCreated = false;
        isUIVisible = false;
        pageIndex = 1;
    }
}

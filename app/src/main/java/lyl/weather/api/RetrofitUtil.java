package lyl.weather.api;


import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;
import lyl.weather.model.CustomerPayRecords;
import lyl.weather.model.Customers;
import lyl.weather.model.LoginSucess;
import lyl.weather.model.Logout;
import lyl.weather.model.Menu;
import lyl.weather.model.ModifyPassword;
import lyl.weather.model.ResultInfo;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author lyl
 * @date 2017/11/27.
 */

public class RetrofitUtil {
    public static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private ApiService mApiService;

    private static RetrofitUtil mInstance;

    Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request()
                    .newBuilder()
                    .addHeader("token", com.rn.base.user.UserInfo.getInstance().getToken())
                    .build();
            return chain.proceed(newRequest);
        }
    };

    /**
     * 私有构造方法
     */
    private RetrofitUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        /**
         * 添加拦截器
         * 添加公共的header 请求头
         */
        if (type == 1) {

        } else {
            builder.addInterceptor(interceptor);
        }

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl("http://36.7.144.130:6020/")
                //添加相应结果解析器,存放于Retrofit.Builder类的converterFactories集合中
                //主要是json格式数据的返回，所以这里使用GsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                //addCallAdapterFactory添加访问处理适配器,存放于Retrofit.Builder类的adapterFactories集合中。
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public static RetrofitUtil getInstance() {
        if (type == 1) {
            mInstance = null;
        }
        type = 2;
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                mInstance = new RetrofitUtil();
            }
        }
        return mInstance;
    }

    public static int type = 1;

    public static RetrofitUtil getInstance1() {
        mInstance = new RetrofitUtil();
        type = 1;
        return mInstance;
    }


    /**
     * 登录
     *
     * @param subscriber
     */
    public void login(Map<String, String> map, Subscriber<LoginSucess> subscriber) {
        mApiService.login(map)
                .compose(RxHelper.<LoginSucess>rxSchedulerHelper())
                .subscribe(subscriber);
    }


    /**
     * 登录
     *
     * @param subscriber
     */
    public void login1(Map<String, String> map, Subscriber<LoginSucess> subscriber) {
        mApiService.login1(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 登录
     *
     * @param subscriber
     */
    public void getMenu(Subscriber<Menu> subscriber) {
        mApiService.getMenu()
                .compose(RxHelper.<Menu>rxSchedulerHelper())
                .subscribe(subscriber);
    }


    public void prepayCost(int id, PayMoney payMoney, Subscriber<ResultInfo> subscriber) {
        mApiService.getCostPrepay(id, payMoney)
                .compose(RxHelper.<ResultInfo>rxSchedulerHelper())
                .subscribe(subscriber);
    }

    public void prepayCost1(int id, JSONObject requestBody, Subscriber<ResultInfo> subscriber) {
        mApiService.getCostPrepay1(id, requestBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }


    /**
     * 获取版本信息
     *
     * @param subscriber
     */
    public void getVersionInfo(Subscriber<VersionInfo> subscriber) {
        mApiService.getVersionInfo()
                .compose(RxHelper.<VersionInfo>rxSchedulerHelper())
                .subscribe(subscriber);
    }

    /**
     * 修改密码
     *
     * @param modifyPass
     * @param subscriber
     */
    public void modifyPass(ModifyPass modifyPass, Subscriber<ModifyPassword> subscriber) {
        mApiService.modifuPass(modifyPass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }


    /**
     * 获取实时费用列表
     *
     * @param term
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public void getCurrentcostDatas(String term, int pageIndex, int pageSize, Subscriber<CurrentCostDatas> subscriber) {
        mApiService.getCurrentcostDatas(term, pageIndex, pageSize)
                .compose(RxHelper.<CurrentCostDatas>rxSchedulerHelper())
                .subscribe(subscriber);
    }


    public void getCurrentcost(Subscriber<CurrentCost> subscriber) {
        mApiService.getCurrentcost()
                .compose(RxHelper.<CurrentCost>rxSchedulerHelper())
                .subscribe(subscriber);
    }

    public void getCustom(String term, Subscriber<Customers> subscriber) {
        mApiService.getCustom(term)
                .compose(RxHelper.<Customers>rxSchedulerHelper())
                .subscribe(subscriber);
    }

    public void getUserinfo(Subscriber<UserInfo> subscriber) {
        mApiService.getUserinfo()
                .compose(RxHelper.<UserInfo>rxSchedulerHelper())
                .subscribe(subscriber);

    }

    public void logout(Subscriber<Logout> subscriber) {
        mApiService.logout()
                .compose(RxHelper.<Logout>rxSchedulerHelper())
                .subscribe(subscriber);

    }

    /**
     * 获取预交记录
     *
     * @param map
     * @param subscriber
     */
    public void getCustomerPayRecords(Map<String, String> map, Subscriber<CustomerPayRecords> subscriber) {
        mApiService.getCustomerPayRecords(map)
                .compose(RxHelper.<CustomerPayRecords>rxSchedulerHelper())
                .subscribe(subscriber);
    }
}

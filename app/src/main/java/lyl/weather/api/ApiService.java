package lyl.weather.api;



import org.json.JSONObject;

import java.util.Map;

import lyl.weather.model.CurrentCost;
import lyl.weather.model.CurrentCostDatas;
import lyl.weather.model.CustomerPayRecords;
import lyl.weather.model.Customers;
import lyl.weather.model.LoginSucess;
import lyl.weather.model.Logout;
import lyl.weather.model.Menu;
import lyl.weather.model.ResultInfo;
import lyl.weather.model.UserInfo;
import lyl.weather.model.VersionInfo;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * @author lyl
 * @date 2017/11/27.
 *
 * Retrofit + Rxjava
 *
 */

public interface ApiService {

    /**
     * 登录
     *
     * @param map 参数集合
     * @return
     */
    @GET("api/phone/logins")
    Observable<LoginSucess> login(@QueryMap Map<String, String> map);

    /**
     * java.lang.IllegalArgumentException: @FieldMap parameters can only be used with form encoding. (parameter #1)
     * for method ApiService.login1
     *
     * @param map
     * @return 一般get请求都用@query
     * 一般post请求都用@field
     */
    @GET("api/phone/logins")
    Observable<LoginSucess> login1(@FieldMap Map<String, String> map);


    /**
     * 获取菜单
     *
     * @return
     */
    @GET("/api/phone/roles/menus")
    Observable<Menu> getMenu();


    /**
     * 费用预缴
     *
     * @param id
     * @param payMoney
     * @return
     */
    @POST("/api/phone/customers/{id}/customerPayRecords")
    @Headers({"Content-Type: application/json", "Accept:  application/json"})
    Observable<ResultInfo> getCostPrepay(@Path("id") int id, @Body PayMoney payMoney);

    /**
     * 不能以body的方式传递json参数
     *
     * @param id
     * @param requestBody
     * @return
     */
    @POST("/api/phone/customers/{id}/customerPayRecords")
    @Headers({"Content-Type: application/json", "Accept:  application/json"})
    Observable<ResultInfo> getCostPrepay1(@Path("id") int id, @Body JSONObject requestBody);


    @GET("/api/phone/customers/customerPayRecords")
    Observable<CustomerPayRecords> getCustomerPayRecords(@QueryMap Map<String, String> map);


    /**
     * 获取版本信息
     *
     * @return
     */
    @GET("/api/phone/appVersion")
    Observable<VersionInfo> getVersionInfo();

    /**
     * 修改密码
     *
     * @param modifyPass
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept:  application/json"})
    @PUT("/api/phone/users/passwords")
    Observable<ModifyPass> modifuPass(@Body ModifyPass modifyPass);


    /**
     * 获取实时费用列表
     *
     * @param term
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GET("/api/phone/customers/customerRealTimeDatas")
    Observable<CurrentCostDatas> getCurrentcostDatas(@Query("term") String term,
                                                     @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    /**
     * 获取基本信息
     *
     * @return
     */
    @GET("/api/phone/customers/customerRealTimeDatas/statistics")
    Observable<CurrentCost> getCurrentcost();


    /**
     * 获取预交费商户
     *
     * @param term
     * @return
     */
    @GET("/api/phone/customers")
    Observable<Customers> getCustom(@Query("term") String term);


    /**
     * 注销登录
     *
     * @return
     */
    @DELETE("/api/phone/logouts")
    Observable<Logout> logout();

    /**
     * 获取个人信息
     *
     * @return
     */
    @GET("/api/phone/users")
    Observable<UserInfo> getUserinfo();
}

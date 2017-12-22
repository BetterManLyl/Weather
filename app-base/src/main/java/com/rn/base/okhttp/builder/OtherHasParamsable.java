package com.rn.base.okhttp.builder;

import java.util.Map;

/**
 * Created by zhy on 16/3/1.
 */
public interface OtherHasParamsable
{
    OtherRequestBuilder params(Map<String, String> params);
    OtherRequestBuilder addParams(String key, String val);
}

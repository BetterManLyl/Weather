package com.rn.base.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Isay on 2017/2/25.
 */
public class RegularExpression {

    /**
     *
     * @param strSource
     * @return 是数值，且小数点前最多2位，小数点后最多2未
     */
    public static boolean isNumber(String strSource) {
        if(TextUtils.isEmpty(strSource)){
            return false;
        }
        // 要验证的规则
        String regEx = "([0-9]{1,2})|([0-9]{1,2}[.][0-9]{1,2})|-([0-9]{1,2})|-([0-9]{1,2}+[.][0-9]{1,2})";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strSource);
        // 字符串是否与正则表达式相匹配
        return matcher.matches();
    }

}

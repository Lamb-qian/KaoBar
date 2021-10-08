package com.qian.kaobar.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class WebUtils {
    /**
     *
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            /**
             * 把所有请求的参数都注入到T中
             */
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}

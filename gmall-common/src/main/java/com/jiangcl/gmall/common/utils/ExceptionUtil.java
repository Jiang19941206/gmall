package com.jiangcl.gmall.common.utils;

import java.util.Arrays;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc 异常处理类
 */
public class ExceptionUtil {

    /**
     * @desc 将异常信息转换为字符串
     * @author jiangcl
     * @date 2020/6/16
     * @param e
     * @return java.lang.String
     */
    public static String getErrorInfo(Exception e){
        StackTraceElement []elements=e.getStackTrace();
        StringBuffer error=new StringBuffer();
        error.append(e.toString());
        Arrays.stream(elements).forEach((element)->{
            error.append("\n\t"+element.toString());
        });
        return error.toString();
    }
}

package com.jiangcl.gmall.web.exception;

import com.jiangcl.gmall.common.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc controller全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理方法，在方法上加上@ExceptionHandler即可处理全局异常
     *  若不指定value，则全部异常都会在此方法里面进行处理
     *  若指定value的值，则发生与value类型一致的异常时，在指定的方法连进行异常处理
     */

    /**
     * @desc 处理算数异常
     * @author jiangcl
     * @date 2020/9/18
     * @param e
     * @return java.lang.Object
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public Object arithmeticException(Exception e){
        log.error("系统出现异常：{}", ExceptionUtil.getErrorInfo(e));
        return errorMap();
    }

    /**
     * @desc 处理空指针异常
     * @author jiangcl
     * @date 2020/9/18
     * @param e
     * @return java.lang.Object
     */
    @ExceptionHandler(value = {NullPointerException.class})
    public Object nullPointException(Exception e){
        log.error("系统出现异常：{}",ExceptionUtil.getErrorInfo(e));
        return errorMap();
    }

    /*
    处理全部异常
    @ExceptionHandler
    public Object allException(Exception e){
        log.error("系统出现异常：{}",e.getStackTrace());
        return errorMap();
    }
    */

    public Map<String,Object> errorMap(){
        Map<String,Object> errorMap = new HashMap();
        errorMap.put("code",500);
        errorMap.put("msg","failed");
        return errorMap;
    }

}

package com.jiangcl.gmall.web.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc 自定义切面实现数据验证
 *
 *  springboot自定义切面
 *     1、引入相关pom
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-aop</artifactId>
 *         </dependency>
 *      2、在切面类上加上注解：@Aspect
 */
@Slf4j
@Component
@Aspect
public class DataValidAspect {

    /**
     * @desc 定义一个环绕通知对请求参数进行校验
     * @author jiangcl
     * @date 2020/9/17
     * @param point
     * @return java.lang.Object
     */
    @Around("execution(* com.jiangcl.gmall.web.controller.*.*(..))")
    public Object validAround(ProceedingJoinPoint point){
        Object proceed = null;
        try {
            //获取方法的参数信息
            Object[] args = point.getArgs();
            //循环参数
            for (Object arg : args) {
                //若参数为BindingResult类型，则证明进行了参数校验
                if(arg instanceof BindingResult){
                    //根据自身需求完善校验逻辑
                    BindingResult result = (BindingResult) arg;
                    int errorCount = result.getErrorCount();
                    if(errorCount > 0){
                        Map<String,Object> errorMap = new HashMap<>();
                        errorMap.put("code",500);
                        //获取所有的出错字段
                        List<FieldError> fieldErrors = result.getFieldErrors();
                        fieldErrors.forEach(error ->{
                            //获取验证未通过的字段
                            String field = error.getField();
                            //获取返回的错误信息
                            String message = error.getDefaultMessage();
                            errorMap.put("msg",message);
                            //获取出错的字段的值
                            Object value = error.getRejectedValue();
                            log.info("属性：{}，接收到的值：{}，校验出错，提示信息为：{}",field,value,message);
                        });
                        return errorMap;
                    }
                }
            }
            //若参数校验通过，执行方法
            proceed = point.proceed(point.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //若想执行后置通知则在此完善
        }
        return proceed;
    }
}

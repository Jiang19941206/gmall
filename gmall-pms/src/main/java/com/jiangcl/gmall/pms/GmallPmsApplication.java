package com.jiangcl.gmall.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
暴露代理对象注解，用于解决service中调用本类方式时，无法加上被调用方法自身的事物

 在注解中声明不需要加载数据源配置@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
*/
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
@EnableDubbo
@MapperScan(basePackages = "com.jiangcl.gmall.pms.mapper")
@SpringBootApplication
public class GmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }

}

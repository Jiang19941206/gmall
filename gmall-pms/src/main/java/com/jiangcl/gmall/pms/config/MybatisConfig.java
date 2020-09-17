package com.jiangcl.gmall.pms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc mybatis-plus分页插件
 */
@Configuration
public class MybatisConfig {

    /**
     * @desc mybatis-plus分页配置
     * @author jiangcl
     * @date 2020/9/17
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}

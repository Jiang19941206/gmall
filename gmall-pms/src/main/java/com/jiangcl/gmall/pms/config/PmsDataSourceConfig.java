package com.jiangcl.gmall.pms.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author jiangcl
 * @date 2020/9/16
 * @desc
 * 配置读写分离：
 *      1、配置sharding-jdbc.yml文件
 *      2、创建数据源
 */
@Configuration
public class PmsDataSourceConfig {

    @Bean
    public DataSource dataSource() throws Exception{
        File file = ResourceUtils.getFile("classpath:sharding-jdbc.yml");
        //创建主从数据源
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(file);
        return dataSource;
    }
}

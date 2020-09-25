package com.jiangcl.gmall.pms.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangcl
 * @date 2020/9/24
 * @desc
 */
@Configuration
public class JestConfig {
    @Value("${spring.elasticsearch.rest.uris}")
    private String esUris;

    @Bean
    public JestClient jestClient(){
        List<String> uriList = Arrays.asList(esUris.split(","));
        JestClientFactory jestClientFactory = new JestClientFactory();
        jestClientFactory.setHttpClientConfig(new HttpClientConfig
                .Builder(uriList)
                .discoveryEnabled(true)
                .discoveryFrequency(10000l, TimeUnit.MILLISECONDS)
                .build());
        JestClient jestClient = jestClientFactory.getObject();
        return jestClient;
    }
}

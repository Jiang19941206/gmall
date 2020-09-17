package com.jiangcl.gmall.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@EnableDubbo
@SpringBootApplication
public class GmallWebApplication {

    public static void main(String[] args) {
        log.info("web工程开始启动");
        SpringApplication.run(GmallWebApplication.class, args);
    }

}

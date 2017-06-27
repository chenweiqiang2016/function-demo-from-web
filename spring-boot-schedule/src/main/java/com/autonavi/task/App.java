package com.autonavi.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 参考页面：http://blog.csdn.net/loongshawn/article/details/50663393
 */
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration
@Configuration
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
        logger.info("opps");
    }
}

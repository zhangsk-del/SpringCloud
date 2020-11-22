package com.zsk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer//是一个服务注册中心 服务端
@SpringBootApplication
public class ApplicationEurka7001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurka7001.class,args);
    }
}

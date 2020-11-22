package com.zsk.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zsk.payment.dao")
public class ApplicationMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8082.class,args);
    }
}

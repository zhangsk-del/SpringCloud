package com.zsk.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zsk.payment.dao")
public class ApplicationMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8081.class,args);
    }
}

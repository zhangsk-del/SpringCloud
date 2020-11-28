package com.zsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeigeMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeigeMain80.class,args);
    }
}

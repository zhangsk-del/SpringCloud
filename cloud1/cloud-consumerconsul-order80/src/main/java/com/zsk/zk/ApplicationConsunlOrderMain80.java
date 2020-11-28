package com.zsk.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConsunlOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsunlOrderMain80.class,args);
    }
}

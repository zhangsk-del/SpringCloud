package com.zsk.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConsulMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsulMain8006.class,args);
    }
}

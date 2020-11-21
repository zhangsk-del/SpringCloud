package com.zsk.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 不读取数据库，数据源 exclude = DataSourceAutoConfiguration.class
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Consumer80Main {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80Main.class,args);
    }
}

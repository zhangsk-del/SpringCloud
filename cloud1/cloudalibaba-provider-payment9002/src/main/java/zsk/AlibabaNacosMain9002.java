package zsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosMain9002.class,args);
    }
}

package com.zsk.consumer.controller;



import com.zsk.api.domain.Payment;
import com.zsk.consumer.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


@RestController
public class ConsumerConntroller {
//    private static  final String PAYMENT_URL="http://localhost:8081";
    private static  final String PAYMENT_URL="http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalanced loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/add")
    public String add(Payment payment ){
       return restTemplate.postForObject(PAYMENT_URL+"/add",payment,String.class);
    }
    @GetMapping("/consumer/get/{id}")
    public String get(@PathVariable("id")Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id,String.class);
    }


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
package com.zsk.consumer.controller;

import com.zsk.api.domain.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class ConsumerConntroller {
    private static  final String PAYMENT_URL="http://localhost:8081";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/add")
    public String add(Payment payment ){
       return restTemplate.postForObject(PAYMENT_URL+"/add",payment,String.class);
    }
    @GetMapping("/consumer/get/{id}")
    public String get(@PathVariable("id")Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id,String.class);
    }
}
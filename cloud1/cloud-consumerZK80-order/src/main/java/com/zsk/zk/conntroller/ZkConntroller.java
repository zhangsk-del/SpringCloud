package com.zsk.zk.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZkConntroller {
    private static final String ORDERZK="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String payment(){
        return restTemplate.getForObject(ORDERZK+"/payment/zk",String.class);
    }



}

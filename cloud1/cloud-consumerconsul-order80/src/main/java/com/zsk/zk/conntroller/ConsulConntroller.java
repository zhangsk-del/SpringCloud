package com.zsk.zk.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulConntroller {
    private static final String ORDERZK="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(ORDERZK+"/payment/consul",String.class);
    }



}

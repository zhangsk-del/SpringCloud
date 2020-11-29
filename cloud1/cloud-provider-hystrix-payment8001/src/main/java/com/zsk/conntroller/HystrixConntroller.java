package com.zsk.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.zsk.service.HystrixService;

@RestController
public class HystrixConntroller {

    @Autowired
    private HystrixService service;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/hystrix/payment/ok/{id}")
    public String hyPaymentOk(@PathVariable("id") int id){
        String s = service.hyPaymentOk(id);
        return s+"port:"+serverPort;
    }
    @GetMapping("/hystrix/payment/timeout/{id}")
    public String hyPaymentTimeOut(@PathVariable("id")int id){
        String s = service.hyPaymentTimeOut(id);
        return s+"port:"+serverPort;
    }
}

package com.zsk.payment.conntroller;

import com.zsk.api.domain.Payment;
import com.zsk.payment.service.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PamentConntroller {
    @Autowired
    private PaymentServiceImp service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public String add(@RequestBody Payment payment) {
        int num = service.add(new Payment(payment.getId(), payment.getSerial()));
        if (num > 0) return "200" + serverPort;

        return "-1";
    }

    @GetMapping("/get/{id}")
    public Payment get(@PathVariable("id") Long id) {
        Payment payment = service.findById(id);
        if (payment != null) {
            payment.setSerial(payment.getSerial() + serverPort);
            return payment;
        }
        return null;
    }

    /**
     * 服务与发现类
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-com.zsk.service");
    return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     * 超时控制
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }
}

package com.zsk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String hyPaymentOk(@PathVariable("id") int id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String hyPaymentTimeOut(@PathVariable("id")int id);

}

package com.zsk.sevice;

import com.zsk.api.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface FeigeService {
    @GetMapping("/get/{id}")
    public Payment get(@PathVariable("id")Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}

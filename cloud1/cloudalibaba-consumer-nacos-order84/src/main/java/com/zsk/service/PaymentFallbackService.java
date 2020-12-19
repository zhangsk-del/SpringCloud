package com.zsk.service;

import com.zsk.api.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentSQL(Long id) {
        return "服务降级返回,---PaymentFallbackService"+new Payment(id,"errorSerial");
    }
}

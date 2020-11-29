package com.zsk.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String hyPaymentOk(int id) {
        return "ok异常啦";
    }

    @Override
    public String hyPaymentTimeOut(int id) {
        return "timeout异常啦";
    }
}

package com.zsk.payment.service;


import com.zsk.api.domain.Payment;

public interface PaymentServiceBase {


    int add(Payment payment);


    Payment findById(Long id);
}

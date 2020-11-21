package com.zsk.payment.service;

import com.zsk.api.domain.Payment;
import com.zsk.payment.dao.PaymentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentServiceBase {
    @Autowired
    private PaymentDao dao;

    public int add(Payment payment) {
        return dao.add(payment);
    }

    @Override
    public Payment findById(Long id) {
        return dao.findById(id);
    }
}

package com.zsk.conntroller;

import com.zsk.api.domain.Payment;
import com.zsk.sevice.FeigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeigeConntroller {

    @Autowired
    private FeigeService feigeService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id){
        return feigeService.get(id);
    }



}

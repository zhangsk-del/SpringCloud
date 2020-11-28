package com.zsk.payment.conntroller;
import com.zsk.api.domain.Payment;
import com.zsk.payment.service.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PamentConntroller {
    @Autowired
    private PaymentServiceImp service;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public String add(@RequestBody Payment payment){
        int num = service.add(new Payment(payment.getId(), payment.getSerial()));
        if (num>0) return "200"+serverPort;

        return "-1";
    }
    @GetMapping("/get/{id}")
    public Payment get(@PathVariable("id") Long id){
        Payment payment = service.findById(id);
        if (payment!=null) {
            payment.setSerial(payment.getSerial()+serverPort);
            return payment;
        }
        return null;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}

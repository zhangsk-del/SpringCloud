package com.zsk.conntroller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zsk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "hyPaymentTimeOutDefaultFallback")//服务降级
public class PaymentConntroller {
    @Autowired
    private PaymentService service;

    @GetMapping("/consumer/hystrix/payment/ok/{id}")
    public String hyPaymentOk(@PathVariable("id") int id) {
    return service.hyPaymentOk(id);
    }

//    @HystrixCommand(fallbackMethod = "hyPaymentTimeOutFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })//指定某一个方法
    @HystrixCommand//使用全局服务降级方法
    @GetMapping("/consumer/hystrix/payment/timeout/{id}")
    public String hyPaymentTimeOut(@PathVariable("id") int id) {
        return service.hyPaymentTimeOut(id);
    }

    /**
     * 服务降级,指定方法
     * @param id
     * @return
     */
    public String hyPaymentTimeOutFallback(@PathVariable("id")int id){
        return "80系统繁忙";
    }


    /**
     * 服务降级,全局方法
     * @return
     */
    public String hyPaymentTimeOutDefaultFallback(){
        return "80系统繁忙Defaul";
    }
}

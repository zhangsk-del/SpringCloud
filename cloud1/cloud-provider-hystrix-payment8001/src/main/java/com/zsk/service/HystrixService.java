package com.zsk.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    public String hyPaymentOk(int id){
        return "线程"+Thread.currentThread().getName()+"hyPaymentOk" +id;
    }


    @HystrixCommand(fallbackMethod = "hyPaymentTimeOutFallback",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            }
    )
    public String hyPaymentTimeOut(int id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int num=10/0;
        return "线程"+Thread.currentThread().getName()+"hyPaymentTimeOut" +id;
    }

    /**
     * 服务降级方法
     * @param id
     * @return
     */
    public String hyPaymentTimeOutFallback(int id){
        return "系统繁忙，请稍后再试";
    }
}

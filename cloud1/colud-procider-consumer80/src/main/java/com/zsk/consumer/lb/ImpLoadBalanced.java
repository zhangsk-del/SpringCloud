package com.zsk.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Configuration
public class ImpLoadBalanced implements LoadBalanced {
    //原子类 从0开始
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    //cas+自旋锁
    private final int getAtomicInteger(){
        int current;
        int next;
        do {
           current= this.atomicInteger.get();
           next=current>=Integer.MAX_VALUE?0:current+1;
            System.out.println("***********"+next);
        }while (!atomicInteger.compareAndSet(current,next));//第一个参数是期望值，第二个参数是修改值是
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int cunt = this.getAtomicInteger() % serviceInstances.size();
        System.out.println("***********666666"+cunt);
        return serviceInstances.get(cunt);
    }
}

package com.zsk.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        try {
            int a=10/0;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB() {
        System.out.println("-------");
        return "------testB";
    }

    @GetMapping("/testHotKey") //required=false p1参数不是必须的
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }


}

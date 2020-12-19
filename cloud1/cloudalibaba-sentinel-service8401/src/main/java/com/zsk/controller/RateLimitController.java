package com.zsk.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.zsk.api.domain.Payment;
import com.zsk.handelr.MyHandelr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource() {
        return "byResource限流测试";
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",blockHandlerClass = MyHandelr.class,
            blockHandler = "handleException")
    public String byUrl()
    {
        return "按url限流测试OK";
    }
}
package com.zsk.handelr;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyHandelr {


    public static String handleException(BlockException exception) {
        return "handleException服务不可用";
    }
}

package com.zsk.filer;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义filer
 */
@Component
public class FilerGateway implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //请求是否带 username参数  http://localhost:9527/payment/lb?username=123 正确请求
        String uname = exchange.getRequest().getQueryParams().getFirst("username");
        //http://localhost:9527/payment/lb  错误请求


        if (uname==null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//给人家一个回应
            return exchange.getResponse().setComplete();
        }
        //放行
       return chain.filter(exchange);


    }



    @Override
    public int getOrder() {
        return 0;
    }
}

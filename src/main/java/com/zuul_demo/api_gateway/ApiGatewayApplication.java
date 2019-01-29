package com.zuul_demo.api_gateway;

import com.zuul_demo.api_gateway.zuul_filter.AccessFIlter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy //该注解开启Zuul网关服务功能 注：Proxy——代理服务器
@SpringCloudApplication  //创建应用主类
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public AccessFIlter accessFIlter(){
        return new AccessFIlter();
    }

}


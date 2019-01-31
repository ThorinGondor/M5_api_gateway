package com.zuul_demo.api_gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/local/hello", method = RequestMethod.GET)
    public String localHello(){
        return "Hello Api Gateway!";
    }
}

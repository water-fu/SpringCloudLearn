package com.spring.cloud.feign.service.impl;

import com.spring.cloud.feign.service.HelloWorldService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * hystrix
 * Created by fusj on 2017/11/14.
 */
@Component
public class HelloWorldHystrixImpl implements HelloWorldService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hi " + name + ", error!";
    }
}

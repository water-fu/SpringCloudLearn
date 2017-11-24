package com.spring.cloud.ribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.ribbon.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Hello World
 * Created by fusj on 2017/11/13.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloWorldError")
    public String helloWorld(String name) {
        return restTemplate.getForObject("http://SERVICE-HELLO-WORLD/helloWorld?name=" + name, String.class);
    }

    public String helloWorldError(String name) {
        return "hi " + name + ", error!";
    }
}

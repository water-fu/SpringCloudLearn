package com.spring.cloud.feign.service;

import com.spring.cloud.feign.service.impl.HelloWorldHystrixImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Hello World
 * Created by fusj on 2017/11/14.
 */
@FeignClient(value = "service-hello-world", fallback = HelloWorldHystrixImpl.class)
public interface HelloWorldService {

    /**
     * hello world
     * @param name
     * @return
     */
    @RequestMapping(value = "helloWorld", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}

package com.spring.cloud.feign.action;

import com.spring.cloud.feign.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World
 * Created by fusj on 2017/11/14.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    /**
     * hello world
     * @param name
     * @return
     */
    @RequestMapping(value = "helloWorld", method = RequestMethod.GET)
    public String helloWorld(String name) {
        return helloWorldService.hello(name);
    }
}

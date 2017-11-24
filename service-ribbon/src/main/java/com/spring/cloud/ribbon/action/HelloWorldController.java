package com.spring.cloud.ribbon.action;

import com.spring.cloud.ribbon.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World
 * Created by fusj on 2017/11/13.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "helloWorld")
    public String helloWorld(String name) {
        return helloWorldService.helloWorld(name);
    }
}

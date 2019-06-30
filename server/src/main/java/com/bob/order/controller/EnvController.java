package com.bob.order.controller;

import com.bob.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-29 15:09
 * @Description:
 */
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String print(){
        return env;
    }

    @Autowired
    private GirlConfig config;

    @GetMapping("/girl")
    public String girl(){
        return " name:" + config.getName() + "   age:" + config.getAge();
    }
}

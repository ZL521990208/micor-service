package com.soft1851.springcloud.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhengliang
 * @date ：2020/9/23 8:42
 * @description：TODO
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {
    @GetMapping
    public String getHello(){
        return "hello content-center!";
    }

    @GetMapping("/hello")
    public String getUser(){
        log.info("我被调用了");
        return "Hello Spring Cloud, this user-center";
    }
}
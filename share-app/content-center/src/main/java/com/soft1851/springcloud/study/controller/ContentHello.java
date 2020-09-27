package com.soft1851.springcloud.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhengliang
 * @date ：2020/9/22 15:37
 * @description：TODO
 */
@RestController
@RequestMapping(value = "/content")
public class ContentHello {
    @GetMapping
    public String getHello(){
        return "hello content-center!";
    }

}
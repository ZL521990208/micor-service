package com.soft1851.springcloud.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author ：zhengliang
 * @date ：2020/9/23 8:34
 * @description：TODO
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("test")
    public List<ServiceInstance> getInstances(){
        return this.discoveryClient.getInstances("user-center");
    }
    @GetMapping("/call/hello")
    public String callUserCenter() {
        //用户中心所有的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//        ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
////        String targetUrl = serviceInstance.getUri() + "/user/hello";
        Random random = new Random();
        int i = random.nextInt(instances.size());
        String Url = instances.get(i).getUri().toString() + "user/hello";
        //stream编程、Lambda表达式、函数式编程
        //理解这段代码的含义？它实现了什么功能？
//        String Url = instances.stream()
//                .map(instance -> instance.getUri().toString() + "/user/hello")
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("当前没有实例！"));

        log.info("请求目标地址：{}",Url);
        return restTemplate.getForObject(Url, String.class);
    }
    @GetMapping(value = "/call/ribbon")
    public String callByRibbon(){
        return restTemplate.getForObject("http://user-center/user/hello",String.class);
    }

}

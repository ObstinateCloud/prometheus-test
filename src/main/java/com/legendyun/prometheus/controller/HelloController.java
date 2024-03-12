package com.legendyun.prometheus.controller;

import com.legendyun.prometheus.custom.MyMetrics;
import com.legendyun.prometheus.custom2.MyMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @title: HelloController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 14:50
 */
@RestController
public class HelloController {

    @Resource
    private MyMetricsService myMetricsService;

    @Autowired
    private MyMetrics myMetrics;

    @GetMapping("sayHello")
    public String sayHello(String name){
        System.out.println("hello world "+name);
        myMetricsService.aCounter.increment();
        myMetrics.userOnline.add(name);
        System.out.println(myMetrics.userOnline.size());
        return "hello "+ name+" "+ new Date();
    }

    @GetMapping("sayHelloLongTime")
    public String sayHelloLongTime(String name){
        myMetrics.userOnline.remove(name);
        System.out.println(myMetrics.userOnline.size());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world "+name);
        return "hello "+ name+" "+ new Date();
    }
}

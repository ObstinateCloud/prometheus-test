package com.legendyun.prometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @title: IndexController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/11 17:13
 */
@RestController
@RequestMapping("/v1")
public class IndexController {

    @Autowired
    MeterRegistry registry;

    private Counter counter_core;
    private Counter counter_index;

    @PostConstruct
    private void init(){
        counter_core = registry.counter("app_requests_method_count", "method", "IndexController.core","legend-label","legend12333333");
        counter_index = registry.counter("app_requests_method_count", "method", "IndexController.index","legend-label","legend4566666");
    }

    @RequestMapping(value = "/index")
    public Object index(){
        try{
            counter_index.increment();
        } catch (Exception e) {
            return e;
        }
        return counter_index.count() + " index of springboot2-prometheus.";
    }

    @RequestMapping(value = "/core")
    public Object coreUrl(){
        try{
            counter_core.increment();
        } catch (Exception e) {
            return e;
        }
        return counter_core.count() + " coreUrl Monitor by Prometheus.";
    }

}

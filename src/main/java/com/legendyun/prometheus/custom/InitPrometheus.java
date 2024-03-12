package com.legendyun.prometheus.custom;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @title: InitPrometheus
 * @description: 注册自定义指标
 * @auther: zhangjianyun
 * @date: 2024/3/11 16:16
 */
@Component
public class InitPrometheus implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    PrometheusMeterRegistry meterRegistry;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        CollectorRegistry prometheusRegistry = meterRegistry.getPrometheusRegistry();
        prometheusRegistry.register(MyMetrics.requestCounter);
        prometheusRegistry.register(MyMetrics.inprogressRequests);
        prometheusRegistry.register(MyMetrics.requestLatencyHistogram);
        prometheusRegistry.register(MyMetrics.requestLatency);
    }
}

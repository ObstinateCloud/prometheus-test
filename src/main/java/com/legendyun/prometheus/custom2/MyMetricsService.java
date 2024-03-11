package com.legendyun.prometheus.custom2;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @title: MyMetrics
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/11 17:44
 */
@Component
public class MyMetricsService {

    @Autowired
    MeterRegistry meterRegistry;

    public Counter aCounter;

    @PostConstruct
    private void init(){
        aCounter = Counter.builder("legend_custom_counter")  //名称
                .baseUnit("unit") //基础单位
                .description("legendCounter1") //描述
                .tag("tagKey", "tagValue")  //标签
                .register(meterRegistry);//绑定的MeterRegistry
        aCounter.increment();
    }
}

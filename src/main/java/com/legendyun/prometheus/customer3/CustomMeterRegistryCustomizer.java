package com.legendyun.prometheus.customer3;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * @title: CustomMeterRegistryCustomizer
 * @description: 全局增加业务指标
 * @auther: zhangjianyun
 * @date: 2024/3/12 8:53
 */
@Configuration
public class CustomMeterRegistryCustomizer implements MeterRegistryCustomizer<MeterRegistry> {

    @Override
    public void customize(MeterRegistry registry) {
        registry.config().commonTags("role", "master");
    }
}
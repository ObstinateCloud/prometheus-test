package com.legendyun.prometheus;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @title: LegendPrometheusApplication
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 13:45
 */
@SpringBootApplication
public class LegendPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendPrometheusApplication.class,args);
    }


}

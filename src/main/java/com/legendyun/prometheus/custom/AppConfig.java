package com.legendyun.prometheus.custom;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @title: AppConfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/11 16:29
 */
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new PrometheusMetricsInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


}

package com.legendyun.prometheus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @title: RestConfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/11 11:19
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

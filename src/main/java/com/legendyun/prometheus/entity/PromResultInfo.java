package com.legendyun.prometheus.entity;

import lombok.Data;

/**
 * @title: PromResultInfo
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:07
 */

@Data
public class PromResultInfo {


    /**
     * prometheus指标属性
     */
    private PromMetricInfo labels;

    /**
     * prometheus指标值
     */

    private String globalUrl;

    private String health;

    private String lastScrape;

    private String lastScrapeDuration;

    private String scrapeInterval;

    private String scrapePool;

    private String scrapeTimeout;

    private String scrapeUrl;

}

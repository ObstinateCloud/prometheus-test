package com.legendyun.prometheus.entity;

import lombok.Data;

/**
 * @title: PromMetric
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:06
 */
@Data
public class PromMetric {

    /**
     * metric name和描述当前样本特征的labelsets
     */
    private PromMetricInfo metric;

    /**
     * 一个float64的浮点型数据表示当前样本的值。
     */
    private String[] value;

}

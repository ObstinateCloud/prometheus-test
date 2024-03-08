package com.legendyun.prometheus.entity;

import lombok.Data;

import java.util.List;

/**
 * @title: PromDataInfo
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:05
 */
@Data
public class PromDataInfo {

    /**
     * prometheus监控服务指表参数
     */
    private List droppedTargets;
    private List<PromResultInfo> activeTargets;

    /**
     * prometheus监控样本指标参数
     */
    private String resultType;
    private List<PromMetric> result;

}

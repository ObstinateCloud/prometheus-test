package com.legendyun.prometheus.entity;

import lombok.Data;

/**
 * @title: PromResponceInfo
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:04
 */

@Data
public class PromResponceInfo {
    /**
     * 状态
     * 成功-- success
     */
    private String status;

    /**
     * prometheus指标属性和值
     */
    private PromDataInfo data;


}

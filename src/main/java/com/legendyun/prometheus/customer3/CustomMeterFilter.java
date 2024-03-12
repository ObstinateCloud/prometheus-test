package com.legendyun.prometheus.customer3;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.config.MeterFilterReply;
import org.springframework.context.annotation.Configuration;

/**
 * @title: CustomMeterFilter
 * @description: 区局指标过滤
 * @auther: zhangjianyun
 * @date: 2024/3/12 8:54
 */

//@Configuration
public class CustomMeterFilter implements MeterFilter {
    /**
     * 只需要和jvm相关的指标数据，其余的数据一律拒绝
     */
    @Override
    public MeterFilterReply accept(Meter.Id id) {
        if (id.getName().startsWith("jvm")) {
            return MeterFilterReply.ACCEPT;
        }
        return MeterFilterReply.DENY;
    }
}

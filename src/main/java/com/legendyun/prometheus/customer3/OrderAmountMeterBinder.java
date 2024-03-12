package com.legendyun.prometheus.customer3;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @title: OrderAmountMeterBinder
 * @description: 自定义指标依赖于其他bean对象时
 * @auther: zhangjianyun
 * @date: 2024/3/12 8:56
 */
@Component
public class OrderAmountMeterBinder implements MeterBinder {

    @Autowired
    private OrderService orderService;

    @Override
    public void bindTo(@NonNull MeterRegistry registry) {
        Gauge.builder("order_amount", orderService, service -> service.retrieveOrderAmount().doubleValue())
                // 这个 fen 会接到 order_amount的后面及在 prometheus 中的指标名称为 order_amount_fen
                .baseUnit("fen")
                .description("获取订单的金额")
                .tag("system", "order")
                .strongReference(false)
                .register(registry);
    }
}

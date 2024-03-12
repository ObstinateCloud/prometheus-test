package com.legendyun.prometheus.controller;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @title: HistogramController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/12 10:33
 */
@RestController
@RequestMapping("histogram")
public class HistogramController {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * 接收一个耗时，记录到指标中
     *
     * @param time 表示执行该方法的耗时时间
     * @return String
     */
    @GetMapping("time-consuming")
    public String timeConsuming(@RequestParam("time") int time) throws InterruptedException {

        TimeUnit.SECONDS.sleep(time);

        Timer timer = Timer.builder("time.consuming")
                .tag("method", "time-consuming")
                .publishPercentileHistogram(true)
                // 桶的最小值
                .minimumExpectedValue(Duration.ofSeconds(1))
                // 桶的最大值，超过这个值的数据会放到 le="+Inf" 中
                .maximumExpectedValue(Duration.ofSeconds(10))
                // 对上方分桶的补充，比如：上方1-10没有产生le=6的桶，则此处使用sla(Duration.ofSecond(6))就会产生一个le=6的桶
                .sla(Duration.ofSeconds(6), Duration.ofSeconds(9))
                // 客户端计算分位数，较准确，不过对客户端的性能影响比较大，一般情况下不用,加上这句就是分布式摘要
                .publishPercentiles(0.1, 0.5, 0.95, 0.99)
                // 下方这2个参数，没搞明白，估计是和 summary 相关
                .distributionStatisticExpiry(Duration.ofMinutes(2))
                .distributionStatisticBufferLength(3)
                // 描述信息
                .description("统计方法的耗时")
                .register(meterRegistry);

        timer.record(Duration.ofSeconds(time));


        // 这种方式也是可以记录方法的执行时间的
        // Timer.Sample sample = Timer.start(meterRegistry); // 方法执行开始前执行
        // 执行业务逻辑
        // 记录耗时
        // sample.stop(
        //      timer
        // );

        return "ok";
    }

    /**
     * 接收一个耗时，记录到指标中
     *
     * @param time 表示执行该方法的耗时时间
     * @return String
     */
    @GetMapping("time-consuming-with-annotation")
    @Timed(value = "time.annotation", histogram = true)
    public String annotationTimeConsuming(@RequestParam("time") int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
        return "ok";
    }
}

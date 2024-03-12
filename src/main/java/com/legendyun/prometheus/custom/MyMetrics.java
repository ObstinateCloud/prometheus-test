package com.legendyun.prometheus.custom;

import cn.hutool.core.util.RandomUtil;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.distribution.Histogram;
import io.prometheus.client.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: MyMetrics
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/11 16:25
 */
@Component
public class MyMetrics {

    public List<String> userOnline = new ArrayList<>();

    @Autowired
    private MeterRegistry meterRegistry;

    @PostConstruct
    public void  init(){
        requestCounter = Counter.builder("legend_requests_method")
                .tag("method","method")
                .tag("status","status")
                .tag("requestURI","requestURI")
                .description("init counter")
                .baseUnit("unit")
                .register(meterRegistry);
        inprogressRequests = Gauge.builder("legend_http_inprogress_requests",()->userOnline.size())
                .baseUnit("unit")
                .description("用户在线数")
                .tag("method","method")
                .tag("status","status")
                .tag("requestURI","requestURI")
                .register(meterRegistry);


    }

    /**
     * 计数器可以用于记录只会增加不会减少的指标类型，比如记录应用请求的总量(http_requests_total)，
     * cpu使用时间(process_cpu_seconds_total)等。 一般而言，Counter类型的metrics指标在命名中
     * 我们使用_total结束。
     */
    public Counter requestCounter ;

    /**
     * 使用Gauge可以反映应用的当前状态,例如在监控主机时，主机当前空闲的内容大小(node_memory_MemFree)，
     * 可用内存大小(node_memory_MemAvailable)。或者容器当前的CPU使用率,内存使用率。这里我们使用
     * Gauge记录当前应用正在处理的Http请求数量。
     */
    public Gauge inprogressRequests;


    /**
     * 主要用于在指定分布范围内(Buckets)记录大小(如http request bytes)或者事件发生的次数。
     * 以请求响应时间requests_latency_seconds为例
     */
//    public Histogram requestLatencyHistogram = Histogram
//            .labelNames("path", "method", "code")
//            .name("legend_http_requests_latency_seconds_histogram")
//            .help("Request latency in seconds.")
//            .register();
//    public Histogram.Timer histogramRequestTimer;

    /**
     * 和Histogram类似，不同在于Histogram可以通过histogram_quantile函数在服务器端计算分位数，而
     * Sumamry的分位数则是直接在客户端进行定义。因此对于分位数的计算。 Summary在通过PromQL进行查询时
     * 有更好的性能表现，而Histogram则会消耗更多的资源。相对的对于客户端而言Histogram消耗的资源更少
     */
//    public Summary requestLatency = Summary.build()
//            .name("legend_http_requests_latency_seconds_summary")
//            .quantile(0.5, 0.05)
//            .quantile(0.9, 0.01)
//            .labelNames("path", "method", "code")
//            .help("Request latency in seconds.").register();
//    public  Summary.Timer requestTimer;


}

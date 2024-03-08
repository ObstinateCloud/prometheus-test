package com.legendyun.prometheus.entity;

/**
 * @title: PromConstants
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:07
 */
import lombok.Data;

@Data
public class PromConstants {
    /**
     * prometheus-查询SUCCESS
     */
    public static final String SUCCESS = "success";

    /**prometheus-查询参数*/
    public static final String QUERY = "query";

    /**系统CPU使用率*/
    public static final String SYSTEM_CPU_USAGE= "system_cpu_usage";
    /**Java虚拟机可用的处理器数量*/
    public static final String SYSTEM_CPU_COUNT= "system_cpu_count";
    /**JVM的CPU利用率*/
    public static final String PROCESS_CPU_COUNT= "process_cpu_usage";

    /**
     *  tomcat相关参数
     */
    /**tomcat_当前活跃会话数*/
    public static final String TOMCAT_SESSIONS_ACTIVE_CURRENT_SESSIONS = "tomcat_sessions_active_current_sessions";

    /**
     *  jvm 相关参数
     */

    /**Java虚拟机的正常运行时间*/
    public static final String PROCESS_UPTIME_SECONDS = "process_uptime_seconds";

    /**可供Java虚拟机使用的已提交的内存量*/
    public static final String JVM_MEMORT_COMMITTED_BYTES = "jvm_memory_committed_bytes";

    /**自Java虚拟机启动或重置峰值以来的活动线程峰值*/
    public static final String JVM_THREADS_PEAK_THREADS= "jvm_threads_peak_threads";

    /**在一个GC之后到下一个GC之前增加年轻代内存池的大小*/
    public static final String JVM_GC_MEMORT_ALLOCATED_BYTES_TOTAL= "jvm_gc_memory_allocated_bytes_total";

    /**进程的开始时间*/
    public static final String PROCESS_START_TIME_SECONDS= "process_start_time_seconds";

    /**最大内存*/
    public static final String JVM_MEMORT_MAX_BYTES= "jvm_memory_max_bytes";

    /**已使用内存*/
    public static final String JVM_MEMORT_USED_BYTES= "jvm_memory_used_bytes";

    /**请求次数*/
    public static final String HTTP_SERVER_REQUEST_SECONDS_COUNT= "http_server_requests_seconds_count";

    /**请求n次花费的时间*/
    public static final String HTTP_SERVER_REQUEST_SECONDS_SUM= "http_server_requests_seconds_sum";

    /**最长一次花了多长时间*/
    public static final String HTTP_SERVER_REQUEST_SECONDS_MAX= "http_server_requests_seconds_max";

    /**日志总数*/
    public static final String LOGBACK_EVENTS_TOTAL = "logback_events_total";

}



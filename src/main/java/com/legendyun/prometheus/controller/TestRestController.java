package com.legendyun.prometheus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.legendyun.prometheus.entity.PromConstants;
import com.legendyun.prometheus.entity.PromDataInfo;
import com.legendyun.prometheus.entity.PromResponceInfo;
import com.legendyun.prometheus.utils.RestTemplateUtils;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @title: TestController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:09
 */
@Slf4j
@RestController
public class TestRestController {

    private String BASE_URL = "http://192.168.90.152:9090/api/v1/";
    private String ACTION_QUERY = BASE_URL+"query";
    private String ACTION_QUERY_RANGE = BASE_URL+"query_range";
    private String ACTION_SERIES = BASE_URL+"series";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("queryPromQL")
    public JSONObject queryPromQL(String param,long timestamp){
        String param1 = "http_server_requests_seconds_count{instance=\"legend-prometheus-app\"}";
        String param2 = "{instance=\"legend-prometheus-app\"}";

        JSONObject forObject = restTemplate.getForObject(ACTION_QUERY + "?query={1}", JSONObject.class, param);
        System.out.println(forObject);
        return forObject;
    }

    @GetMapping("queryRangePromQL")
    public JSONObject queryRangePromQL(String param, Date start,Date end,float step){
        String param1 = "http_server_requests_seconds_count{instance=\"legend-prometheus-app\"}";
        String param2 = "{instance=\"legend-prometheus-app\"}";

        JSONObject forObject = restTemplate.getForObject(ACTION_QUERY_RANGE + "?query={1}", JSONObject.class, param);
        System.out.println(forObject);
        return forObject;
    }

    @GetMapping("queryActionPromQL")
    public JSONObject queryActionPromQL(String param){
        // 查询整个metrics 指标名 param=label/__name__/values
        JSONObject forObject = restTemplate.getForObject(BASE_URL + "{1}", JSONObject.class, param);
        System.out.println(forObject);
        return forObject;
    }

    /**
     * 或查询
     * @param param1
     * @param param2
     * @return
     */
    @GetMapping("querySeries")
    public JSONObject querySeries(String param1,String param2){
        // 查询整个metrics 指标名 param=label/__name__/values
        StringBuilder placeHolder = new StringBuilder();
        String[] param = new String[]{param1,param2};
        for (int i = 0; i < param.length; i++) {
            String s = param[i];
            placeHolder.append("match[]={"+i+"}&");
        }
        placeHolder.substring(0,placeHolder.length()-1);
        JSONObject forObject = restTemplate.getForObject(ACTION_SERIES + "?"+placeHolder, JSONObject.class, param);
        System.out.println(forObject);
        return forObject;
    }

    /**
     * 标签查询
     * @param param
     * @return
     */
    @GetMapping("queryLabel")
    public JSONObject queryLabel(String param){
        // 查询所有指标名 param=labels
        // 查询指定指标名的值 param=label/${label_name}/values
        JSONObject forObject = restTemplate.getForObject(BASE_URL + "{1}", JSONObject.class, param);
        System.out.println(forObject);
        return forObject;
    }




}

package com.legendyun.prometheus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.legendyun.prometheus.entity.PromConstants;
import com.legendyun.prometheus.entity.PromDataInfo;
import com.legendyun.prometheus.entity.PromResponceInfo;
import com.legendyun.prometheus.utils.RestTemplateUtils;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/**
 * @title: TestController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/8 16:09
 */
@Slf4j
public class TestController {

    public static PromDataInfo getDateInfo(String promURL, String promQL) {

        log.info("请求地址：{}，请求QL：{}", promURL, promQL);
        JSONObject param = new JSONObject();
        param.put(PromConstants.QUERY, promQL);
        String http = null;
        try {
            http = RestTemplateUtils.getHttp(promURL, param);
        } catch (Exception e) {
            log.error("请求地址：{}，请求QL：{}，异常信息：{}", promURL, promQL, e);
        }
        PromResponceInfo responceInfo = JSON.parseObject(http, PromResponceInfo.class);
        log.info("请求地址：{}，请求QL：{}，返回信息：{}", promURL, promQL, responceInfo);
        if (Objects.isNull(responceInfo)) {
            return null;
        }
        String status = responceInfo.getStatus();
        if (StringUtils.isBlank(status)
                || !PromConstants.SUCCESS.equals(status)
        ) {
            return null;
        }
        PromDataInfo data = responceInfo.getData();

        return data;
    }

    public static void main(String[] args) {
        String param = PromConstants.HTTP_SERVER_REQUEST_SECONDS_COUNT + "{instance=\"legend-prometheus-app\"}";
//        try {
//            param = URLDecoder.decode(param, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        PromDataInfo dateInfo = getDateInfo("http://192.168.90.152:9090/api/v1/query", param);
        System.out.println("return------");
        System.out.println(dateInfo);

    }
}

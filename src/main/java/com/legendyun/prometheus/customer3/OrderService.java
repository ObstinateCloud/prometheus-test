package com.legendyun.prometheus.customer3;

import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Service;

/**
 * @title: OrderService
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2024/3/12 8:57
 */
@Service
public class OrderService {

    Double retrieveOrderAmount(){
        return RandomUtil.randomDouble(1000);
    }
}

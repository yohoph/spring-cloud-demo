package com.jmsw.product.demob;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 13:51
 * @Description 自动扫描
 */
@Configuration
@ConditionalOnExpression("#{!environment['spring.application.name'].endsWith('" + OrderConfiguration.SERVICE_NAME + "')}")
@EnableFeignClients("com.jmsw.product.demob")
@ComponentScan("com.jmsw.product.demob")
public class OrderConfiguration {

    // FeignClient 用placeholder可以方便的进行内部调用 配置key为jmsw.service.服务名
    // 配置jmsw.service.jmsw-demob=yehao-jmsw-demob来调用jmsw-demob服务
    public static final String PLACE_HOLD_SERVICE_NAME = "${jmsw.service.jmsw-demob:jmsw-demob}";
    public static final String SERVICE_NAME = "jmsw-demob";

    public static final String CURRENT_VERSION = "v1";
    public static final String COMPATIBLE_VERSION = "v1";

}

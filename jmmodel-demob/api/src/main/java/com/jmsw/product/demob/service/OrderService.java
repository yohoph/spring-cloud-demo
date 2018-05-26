package com.jmsw.product.demob.service;

import com.jmsw.product.demob.OrderConfiguration;
import com.jmsw.product.demob.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Response;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 11:47
 * @Description 获取订单信息
 */
//@FeignClient(OrderConfiguration.PLACE_HOLD_SERVICE_NAME)
public interface OrderService {

    /**
     * 保存订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/order/action/saveOrder")
    public Response<Long> saveOrder(OrderInfo order);

    /**
     * 获取订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/order/action/getOrder")
    public Response<OrderInfo> getOrder(OrderInfo orderId);

}

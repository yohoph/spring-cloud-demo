package com.jmsw.product.demob.api;

import com.jmsw.framework.core.vo.Response;
import com.jmsw.product.demob.OrderConfiguration;
import com.jmsw.product.demob.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 14:11
 * @Description 订单服务接口
 */
@FeignClient(OrderConfiguration.PLACE_HOLD_SERVICE_NAME)
public interface OrderApi {

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
    public Response<OrderInfo> getOrder(String orderId);

}

package com.jmsw.product.demob.controller;

import com.jmsw.common.utils.GsonUtils;
import com.jmsw.common.utils.IdGen;
import com.jmsw.framework.core.vo.Response;
import com.jmsw.framework.core.vo.ResponseUtils;
import com.jmsw.product.demob.api.OrderApi;
import com.jmsw.product.demob.entity.OrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 11:44
 * @Description 订单接口服务实现
 */
@RestController
public class OrderController implements OrderApi{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response<Long> saveOrder(OrderInfo order) {
        if(order == null){
            order = new OrderInfo();
            order.setOrderId(IdGen.uuid());
            order.setUserId("yehao");
            order.setProductId("yehao-product");
            order.setPrice(100L);
            order.setCreateTime(new Date());
        }
        System.out.println(GsonUtils.parseJson(order));
        return ResponseUtils.returnObjectSuccess(1L);
    }

    @Override
    public Response<OrderInfo> getOrder(String orderId) {
        OrderInfo order = new OrderInfo();
        order.setOrderId(IdGen.uuid());
        order.setUserId("yehao");
        order.setProductId("yehao-product");
        order.setPrice(100L);
        order.setCreateTime(new Date());
        return ResponseUtils.returnObjectSuccess(order);
    }
}

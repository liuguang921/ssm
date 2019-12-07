package com.lg.ssm.service.impl;

import com.lg.ssm.SpringBaseTest;
import com.lg.ssm.model.OrderItem;
import com.lg.ssm.model.vo.OrderItemVo;
import com.lg.ssm.model.vo.OrderVo;
import com.lg.ssm.service.One2ManyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 14:53
 */
public class One2ManyServiceImplTest extends SpringBaseTest {

    @Autowired
    private One2ManyService one2ManyService;
    @Test
    public void queryOrderVoByOrderId() {
        OrderVo orderVo= one2ManyService.queryOrderVoByOrderId(8);
        System.out.println(orderVo.getOrderNo());
        for (OrderItem orderItem : orderVo.getOrderItem()) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void queryOrderItemVoByOrderItemId() {
        OrderItemVo orderItemVo = one2ManyService.queryOrderItemVoByOrderItemId(36);
        System.out.println(orderItemVo);
        System.out.println(orderItemVo.getOrder().getOrderNo());
    }
}
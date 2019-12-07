package com.lg.ssm.service.impl;

import com.lg.ssm.mapper.OrderItemMapper;
import com.lg.ssm.mapper.OrderMapper;
import com.lg.ssm.model.vo.OrderItemVo;
import com.lg.ssm.model.vo.OrderVo;
import com.lg.ssm.service.One2ManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 14:48
 */
@Service
public class One2ManyServiceImpl implements One2ManyService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public OrderVo queryOrderVoByOrderId(Integer orderId) {
        return orderMapper.queryOrderVoByOrderId(orderId);
    }

    @Override
    public OrderItemVo queryOrderItemVoByOrderItemId(Integer orderItemId) {
        return orderItemMapper.queryOrderItemVoByOrderItemId(orderItemId);
    }
}

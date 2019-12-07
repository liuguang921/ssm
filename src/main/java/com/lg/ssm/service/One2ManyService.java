package com.lg.ssm.service;

import com.lg.ssm.model.vo.OrderItemVo;
import com.lg.ssm.model.vo.OrderVo;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-22 12:03
 */
public interface One2ManyService {
    OrderVo queryOrderVoByOrderId( Integer orderId);

    OrderItemVo queryOrderItemVoByOrderItemId( Integer orderItemId);

}

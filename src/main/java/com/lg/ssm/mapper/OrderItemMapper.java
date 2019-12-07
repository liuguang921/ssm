package com.lg.ssm.mapper;

import com.lg.ssm.model.OrderItem;
import com.lg.ssm.model.vo.OrderItemVo;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    OrderItemVo queryOrderItemVoByOrderItemId(@Param("orderItemId") Integer orderItemId);


}
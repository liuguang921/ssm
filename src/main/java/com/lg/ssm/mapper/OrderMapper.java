package com.lg.ssm.mapper;

import com.lg.ssm.model.Order;
import com.lg.ssm.model.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    OrderVo queryOrderVoByOrderId(@Param("orderId") Integer orderId);

}
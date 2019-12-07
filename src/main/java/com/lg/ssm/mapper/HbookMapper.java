package com.lg.ssm.mapper;

import com.lg.ssm.model.Hbook;

public interface HbookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Hbook record);

    int insertSelective(Hbook record);

    Hbook selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Hbook record);

    int updateByPrimaryKey(Hbook record);
}
package com.lg.ssm.mapper;

import com.lg.ssm.model.ShiroPermission;

public interface ShiroPermissionMapper {
    int deleteByPrimaryKey(Integer perid);

    int insert(ShiroPermission record);

    int insertSelective(ShiroPermission record);

    ShiroPermission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(ShiroPermission record);

    int updateByPrimaryKey(ShiroPermission record);
}
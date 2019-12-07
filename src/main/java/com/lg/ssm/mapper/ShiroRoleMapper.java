package com.lg.ssm.mapper;

import com.lg.ssm.model.ShiroRole;

public interface ShiroRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(ShiroRole record);

    int insertSelective(ShiroRole record);

    ShiroRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(ShiroRole record);

    int updateByPrimaryKey(ShiroRole record);
}
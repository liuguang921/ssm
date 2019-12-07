package com.lg.ssm.mapper;

import com.lg.ssm.model.ShiroUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShiroUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(ShiroUser record);

    int insertSelective(ShiroUser record);

    ShiroUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(ShiroUser record);

    int updateByPrimaryKey(ShiroUser record);

    ShiroUser queryByName(@Param("uname") String uname);

//    查询用户对应的角色id集合
    Set<String> getRolesByUserId(@Param("userid") Integer userid);

//    查询用户对应的权限名称集合
    Set<String> getPersByUserId(@Param("userid") Integer userid);

}
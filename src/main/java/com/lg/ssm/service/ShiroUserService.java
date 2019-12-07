package com.lg.ssm.service;

import com.lg.ssm.model.ShiroUser;

import java.util.Set;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-12-01 14:27
 */
public interface ShiroUserService {
//    登录
    ShiroUser queryByName( String uname);
//    注册
    int insert(ShiroUser record);

    public Set<String> getRolesByUserId(Integer userId);

    public Set<String> getPersByUserId(Integer userId);

}

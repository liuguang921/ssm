package com.lg.ssm.service.impl;

import com.lg.ssm.mapper.ShiroUserMapper;
import com.lg.ssm.model.ShiroUser;
import com.lg.ssm.service.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-12-01 14:29
 */
@Service("shiroUserService")
public class ShiroUserServiceImpl implements ShiroUserService {
    @Autowired
    private ShiroUserMapper shiroUserMapper;
    @Override
    public ShiroUser queryByName(String uname) {
        return shiroUserMapper.queryByName(uname);
    }

    @Override
    public int insert(ShiroUser record) {
        return shiroUserMapper.insert(record);
    }

    @Override
    public Set<String> getRolesByUserId(Integer userId) {
        return shiroUserMapper.getRolesByUserId(userId);
    }

    @Override
    public Set<String> getPersByUserId(Integer userId) {
        return shiroUserMapper.getPersByUserId(userId);
    }
}

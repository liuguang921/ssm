package com.lg.ssm.shiro;

import com.lg.ssm.model.ShiroUser;
import com.lg.ssm.service.ShiroUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-30 20:10
 */
public class MyRealm extends AuthorizingRealm {
    private ShiroUserService shiroUserService;

    public ShiroUserService getShiroUserService() {
        return shiroUserService;
    }

    public void setShiroUserService(ShiroUserService shiroUserService) {
        this.shiroUserService = shiroUserService;
    }

    /**
     *授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进行授权....");
        ShiroUser shiroUser = this.shiroUserService.queryByName(principals.getPrimaryPrincipal().toString());
//        当前认证过的用户对应的角色ID集合
        Set<String> rolesByUserId = this.shiroUserService.getRolesByUserId(shiroUser.getUserid());
//        当前认证过的用户对应的权限ID集合
        Set<String> persByUserId = this.shiroUserService.getPersByUserId(shiroUser.getUserid());
        AuthorizationInfo info =new SimpleAuthorizationInfo();
        ((SimpleAuthorizationInfo) info).setRoles(rolesByUserId);
        ((SimpleAuthorizationInfo) info).setStringPermissions(persByUserId);
        return info;
    }

    /**
     * 身份认证的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String uname =authenticationToken.getPrincipal().toString();
        String pwd=authenticationToken.getCredentials().toString();
        ShiroUser shiroUser =shiroUserService.queryByName(uname);
        AuthenticationInfo info =new SimpleAuthenticationInfo(
                shiroUser.getUsername(),
                shiroUser.getPassword(),
                ByteSource.Util.bytes(shiroUser.getSalt()),
                this.getName()

        );
        return info;
    }
}

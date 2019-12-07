package com.lg.ssm.controller;

import com.lg.ssm.model.ShiroUser;
import com.lg.ssm.service.ShiroUserService;
import com.lg.ssm.utils.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-12-01 15:29
 */
@Controller
public class ShiroUserController {
    @Autowired
    private ShiroUserService shiroUserService;
//    登录
    @RequestMapping("/login")
    public String login(HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        String uname=req.getParameter("username");
        String pwd=req.getParameter("password");
        UsernamePasswordToken token=new UsernamePasswordToken(uname,pwd);
        try {
//            这里会跳到MyRealm中的认证方法
            subject.login(token);
            req.getSession().setAttribute("username",uname);
            return "main";
        }catch (Exception e){
            req.setAttribute("message","用户名或密码错误！！！");
            return "login";

        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
       subject.logout();
       return "redirect:/login.jsp";
    }

//    注册

    @RequestMapping("/register")
    public String register(HttpServletRequest req){
        String uname=req.getParameter("username");
        String pwd=req.getParameter("password");
        String salt= PasswordHelper.createSalt();
        String credentials =PasswordHelper.createCredentials(pwd,salt);

        ShiroUser shiroUser =new ShiroUser();
        shiroUser.setUsername(uname);
        shiroUser.setPassword(credentials);
        shiroUser.setSalt(salt);
        this.shiroUserService.insert(shiroUser);
        return "redirect:/login.jsp";
    }
}

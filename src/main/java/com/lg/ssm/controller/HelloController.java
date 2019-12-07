package com.lg.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-24 17:23
 *
 * springmvc中五种返回值处理情况
 * 转发3种
 * 转发到安全目录下web-inf下
 * 转发到跟目录
 * 转发到requestMapping
 *
 * 重定向2种
 * 跟目录
 * requestMapping
 *
 */
@Controller
public class HelloController {
//
    @RequestMapping("/say1")
    public String say1(){
        return "hello";
    }

    // 按照springmvc的流程进行编写
    @RequestMapping("/say2")
    public ModelAndView say2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/hello2");
        mv.addObject("msg","第二次使用：springmvc");
        return  mv;
    }

//    转发到安全目录下web-inf下
    @RequestMapping("/req1")
    public String req1(){
        System.out.println("转发到安全目录下web-inf下");
        return "a";
}

    //    转发到跟目录
    @RequestMapping("/req2")
    public String req2(){
        System.out.println("转发到跟目录");
        return "forward:/b.jsp";
    }
    //    转发到requestMapping
    @RequestMapping("/req3")
    public String req3(){
        System.out.println("转发到requestMapping");
        return "forward:/req2";
    }

    //    跟目录
    @RequestMapping("/red1")
    public String red1(){
        System.out.println("跟目录red1..");
        return "redirect:/b.jsp";
    }

    //    requestMapping
    @RequestMapping("/red2")
    public String red2(){
        System.out.println("跟目录red2...");
        return "redirect:/req2";
    }


}

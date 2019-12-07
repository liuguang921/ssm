package com.lg.ssm.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lg.ssm.utils.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-17 19:51
 */
@Component
@Aspect
public class PagerAspect {
    @Around("execution(* *..*Service.*Pager(..))")
    public  Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
//        获取目标对象方法的参数集合
        Object[] args = joinPoint.getArgs();
        PageBean pageBean=null;
        for (Object arg : args) {
            if(arg instanceof PageBean){
                pageBean =(PageBean)arg;
                break;
            }
        }
        if(pageBean!=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        Object proceed = joinPoint.proceed(args);
        if(pageBean!=null && pageBean.isPagination()){
            PageInfo PageInfo =new PageInfo((List)proceed);
            pageBean.setTotal(PageInfo.getTotal()+"");
        }
        return proceed;
    }
}

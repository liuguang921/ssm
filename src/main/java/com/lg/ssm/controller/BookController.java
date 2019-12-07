package com.lg.ssm.controller;

import com.lg.ssm.model.Book;
import com.lg.ssm.service.BookService;
import com.lg.ssm.utils.PageBean;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-25 16:25
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/list")
    public String list(Book book,HttpServletRequest req){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Map> list = bookService.listPager(book, pageBean);
        req.setAttribute("bookList",list);
        req.setAttribute("pagebean",pageBean);
        return "bookList";
    }


    @RequestMapping("/preSave")
    public String preSave(Book book, HttpServletRequest req){
        if (book == null || book.getBid() ==null || book.getBid()==0){
            return "bookEdit";
        }
        Map map = bookService.listPager(book, null).get(0);
        req.setAttribute("b",map);
        return "bookEdit";
    }

    @RequestMapping("/add")
    public String add(Book book){
        bookService.insertSelective(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/edit")
    public String edit(Book book){
        bookService.updateByPrimaryKeySelective(book);
        return  "redirect:/book/list";
    }

    @RequestMapping("/del/{bid}")
    public String del(@PathVariable("bid")Integer bid){
        bookService.deleteByPrimaryKey(bid);
        return  "redirect:/book/list";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("D:/image/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "redirect:/book/list";
    }


    /*  josn */
    @ResponseBody
    @RequestMapping("/json1")
    public Map json1(Book book,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Map> list = this.bookService.listPager(book, pageBean);
        Map map = new HashMap();
        map.put("total",pageBean.getTotal());
        map.put("data",list);
        return map;
    }
    @ResponseBody
    @RequestMapping("/json2")
    public   List<Map> json2(Book book,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Map> list = this.bookService.listPager(book, pageBean);
        return list;
    }

    @ResponseBody
    @RequestMapping("/json3")
    public String json3(Book book,HttpServletRequest request){
        return "springmvc string to josn";
    }

    @RequiresUser
    @ResponseBody
    @RequestMapping("/passUser")
    public String passUser(HttpServletRequest req){
        return "pass user 。。。";
    }

    @RequiresRoles(value = {"2","4"},logical = Logical.OR)
    @ResponseBody
    @RequestMapping("/passRole")
    public String passRole(HttpServletRequest req){
        return "pass role 。。。";
    }

    @RequiresPermissions(value = {"user:load","user:export"},logical = Logical.AND)
    @ResponseBody
    @RequestMapping("/passAuth")
    public String passAuth(HttpServletRequest req){
        return "pass auth 。。。";
    }



}

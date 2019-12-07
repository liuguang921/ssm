package com.lg.ssm.service.impl;

import com.lg.ssm.SpringBaseTest;
import com.lg.ssm.service.BookService;
import com.lg.ssm.utils.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-17 19:28
 */
public class BookServiceImplTest extends SpringBaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void deleteByPrimaryKey() {
        bookService.deleteByPrimaryKey(22);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println(bookService.selectByPrimaryKey(22));
    }

    @Test
    public void listPager() {
        Map map =new HashMap();
        map.put("bname","%圣墟%");
        PageBean pageBean =new PageBean();
        pageBean.setPage(3);
        for (Map map1 : this.bookService.listPager(map, pageBean)) {
            System.out.println(map1);
        }
        System.out.println(pageBean);
    }

    @Test
    public void selectByPrimaryKeyCache() {
        System.out.println(bookService.selectByPrimaryKey(21));
        System.out.println(bookService.selectByPrimaryKey(21));

    }

    @Test
    public void listPagerCache() {
        Map map =new HashMap();
        map.put("bname","%圣墟%");
        PageBean pageBean =new PageBean();
        pageBean.setPage(3);
        for (Map map1 : this.bookService.listPager(map, pageBean)) {
            System.out.println(map1);
        }
        for (Map map2 : this.bookService.listPager(map, pageBean)) {
            System.out.println(map2);
        }
        System.out.println(pageBean);
    }

}
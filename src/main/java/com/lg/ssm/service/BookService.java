package com.lg.ssm.service;

import com.lg.ssm.model.Book;
import com.lg.ssm.utils.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-17 19:10
 */
public interface BookService {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Map> listPager(Map map, PageBean pageBean);

    List<Map> listPager(Book book, PageBean pageBean);
}

package com.lg.ssm.service.impl;

import com.lg.ssm.mapper.BookMapper;
import com.lg.ssm.model.Book;
import com.lg.ssm.service.BookService;
import com.lg.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-17 19:12
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }



    @Override
    public List<Map> listPager(Map map, PageBean pageBean) {
        return bookMapper.listPager(map);
    }

    @Override
    public List<Map> listPager(Book book, PageBean pageBean) {
        Map map =new HashMap();
        map.put("bname",book.getBname());
        return bookMapper.listPager(map);
    }
}

package com.lg.ssm.service.impl;

import com.lg.ssm.mapper.HbookCategoryMapper;
import com.lg.ssm.model.vo.CategoryVo;
import com.lg.ssm.model.vo.HbookVo;
import com.lg.ssm.service.Many2ManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 15:48
 */
@Service
public class Many2ManyServiceImpl implements Many2ManyService {
    @Autowired
    private HbookCategoryMapper hbookCategoryMapper;
    @Override
    public HbookVo queryByBookId(Integer bookId) {
        return hbookCategoryMapper.queryByBookId(bookId);
    }

    @Override
    public CategoryVo queryByCid(Integer cid) {
        return hbookCategoryMapper.queryByCid(cid);
    }
}

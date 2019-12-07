package com.lg.ssm.service;

import com.lg.ssm.model.vo.CategoryVo;
import com.lg.ssm.model.vo.HbookVo;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 15:47
 */
public interface Many2ManyService {
    HbookVo queryByBookId(Integer bookId);

    CategoryVo queryByCid(Integer cid);
}

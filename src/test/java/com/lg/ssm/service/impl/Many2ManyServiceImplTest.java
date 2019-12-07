package com.lg.ssm.service.impl;

import com.lg.ssm.SpringBaseTest;
import com.lg.ssm.model.Category;
import com.lg.ssm.model.Hbook;
import com.lg.ssm.model.vo.CategoryVo;
import com.lg.ssm.model.vo.HbookVo;
import com.lg.ssm.service.Many2ManyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 15:51
 */
public class Many2ManyServiceImplTest extends SpringBaseTest {

    @Autowired
    private Many2ManyService many2ManyService;
    @Test
    public void queryByBookId() {
        HbookVo hbookVo = many2ManyService.queryByBookId(8);
        System.out.println(hbookVo);
        for (Category category : hbookVo.getCategories()) {
            System.out.println(category);
        }

    }

    @Test
    public void queryByCid() {
        CategoryVo categoryVo = many2ManyService.queryByCid(8);
        System.out.println(categoryVo);
        for (Hbook hbook : categoryVo.getHbook()) {
            System.out.println(hbook);
        }

    }
}
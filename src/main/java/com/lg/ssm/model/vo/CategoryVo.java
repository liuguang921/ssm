package com.lg.ssm.model.vo;

import com.lg.ssm.model.Category;
import com.lg.ssm.model.Hbook;

import java.util.List;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 15:25
 */
public class CategoryVo extends Category {
    private List<Hbook> hbook;

    public List<Hbook> getHbook() {
        return hbook;
    }

    public void setHbook(List<Hbook> hbook) {
        this.hbook = hbook;
    }
}

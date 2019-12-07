package com.lg.ssm.model.vo;

import com.lg.ssm.model.Category;
import com.lg.ssm.model.Hbook;

import java.util.List;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-23 15:23
 */
public class HbookVo extends Hbook {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

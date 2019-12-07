package com.lg.ssm.mapper;

import com.lg.ssm.model.HbookCategory;
import com.lg.ssm.model.vo.CategoryVo;
import com.lg.ssm.model.vo.HbookVo;
import org.apache.ibatis.annotations.Param;

public interface HbookCategoryMapper {
    int deleteByPrimaryKey(Integer bcid);

    int insert(HbookCategory record);

    int insertSelective(HbookCategory record);

    HbookCategory selectByPrimaryKey(Integer bcid);

    int updateByPrimaryKeySelective(HbookCategory record);

    int updateByPrimaryKey(HbookCategory record);

    HbookVo queryByBookId(@Param("bookId") Integer bookId);

    CategoryVo queryByCid(@Param("cid") Integer cid);
}
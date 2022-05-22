package com.evan.wj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evan.wj.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author 北落燕门
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询书籍目录
     *
     * @return
     */
    ArrayList<Category> selectName();

}

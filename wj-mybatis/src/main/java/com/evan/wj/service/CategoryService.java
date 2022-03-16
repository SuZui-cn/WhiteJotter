package com.evan.wj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evan.wj.mapper.CategoryMapper;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 北落燕门
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryMapper.selectList(null);
    }

    public Category get(int id) {
        return categoryMapper.selectById(id);
//        return categoryMapper.findById(id).orElse(null);
    }
}

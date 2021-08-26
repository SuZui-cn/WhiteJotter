package com.evan.wj.service;

import com.evan.wj.dao.CategoryDao;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 北落燕门
 */
@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id) {
        return categoryDao.findById(id).orElse(null);
    }
}

package com.evan.wj.dao;

import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 北落燕门
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
    
}

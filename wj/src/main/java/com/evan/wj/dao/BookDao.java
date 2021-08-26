package com.evan.wj.dao;

import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 北落燕门
 */
public interface BookDao extends JpaRepository<Book, Integer> {
    
    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

}

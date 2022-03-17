package com.evan.wj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 北落燕门
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    /**
     * 查询所有图书
     *
     * @return
     */
    ArrayList<Book> getAllBooks();


    /**
     * 根据目录ID查询所有图书
     *
     * @param category 目录
     * @return 书籍
     */
    List<Book> findAllByCategory(Category category);


    /**
     * 根据标题或者作者进行模糊查询
     *
     * @param keyword 关键词
     * @return 书籍
     */
    List<Book> findAllByTitleLikeOrAuthorLike(@Param("keyword") String keyword);


    /**
     * 根据ID查找图书
     *
     * @param id 书籍编号
     * @return 书籍实体
     */
    Book findBookById(@Param("id") int id);


    /**
     * 保存图书
     *
     * @param book
     */
    void saveBook(Book book);


    /**
     * 更新图书
     *
     * @param book
     */
    void updateBook(Book book);


}

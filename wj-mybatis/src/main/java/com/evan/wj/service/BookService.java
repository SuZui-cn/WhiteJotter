package com.evan.wj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evan.wj.mapper.BookMapper;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 北落燕门
 */
@Service
public class BookService extends ServiceImpl<BookMapper, Book> {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Book> list() {
        return bookMapper.findAllByCategory(null);
    }

    public void addOrUpdate(Book book) {
        Book book1 = bookMapper.findBookById(book.getId());
        if (book1 == null) {
            bookMapper.saveBook(book);
        } else {
            bookMapper.updateBook(book);
        }

    }

    public void deleteById(int id) {
        bookMapper.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookMapper.findAllByCategory(category);
    }

    public List<Book> search(String keyword) {
        return bookMapper.findAllByTitleLikeOrAuthorLike(keyword);
    }
}

package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.User;
import com.evan.wj.service.BookService;
import com.evan.wj.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 北落燕门
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
//        System.out.println(bookService.list().get(1).getCategory());
        return bookService.getAllBooks();
//        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        System.out.println(book);
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keyword") String keyword, HttpSession httpSession) {
        System.out.println(keyword);
        User user = (User) httpSession.getAttribute("user");
        System.out.println(user);
        if ("".equals(keyword)) {
            return bookService.list();
        } else {
            return bookService.search(keyword);
        }
//        if (user != null) {
//            //关键词为空查询所有书籍
//            if ("".equals(keyword)) {
//                return bookService.list();
//            } else {
//                return bookService.search(keyword);
//            }
//        } else {
//            return null;
//        }
//        //关键词为空查询所有书籍
//        if ("".equals(keywords)) {
//            return bookService.list();
//        } else {
//            return bookService.search(keywords);
//        }
    }

    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "F:/code/my_repositories/WhiteJotter/img/";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils
                .getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}

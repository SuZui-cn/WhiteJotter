package com.evan.wj.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 北落燕门
 */
@Data
public class Book {
    @TableId
    int id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;

    private Category category;
}



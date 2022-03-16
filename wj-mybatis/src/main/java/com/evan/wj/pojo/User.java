package com.evan.wj.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 北落燕门
 */
@Data
public class User {
    @TableId
    private int id;
    private String username;
    private String password;
}

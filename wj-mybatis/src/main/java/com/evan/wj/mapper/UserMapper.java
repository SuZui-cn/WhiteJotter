package com.evan.wj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evan.wj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 北落燕门
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(@Param("username") String username);

    /**
     * 根据用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

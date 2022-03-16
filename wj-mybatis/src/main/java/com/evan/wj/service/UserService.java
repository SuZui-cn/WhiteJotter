package com.evan.wj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evan.wj.mapper.UserMapper;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 北落燕门
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    UserMapper userMapper;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String username) {
        return userMapper.findByUsername(username);
    }

    public User get(String username, String password) {
        return userMapper.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userMapper.insert(user);
    }

}

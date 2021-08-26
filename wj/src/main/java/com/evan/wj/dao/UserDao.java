package com.evan.wj.dao;

import com.evan.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 北落燕门
 */
public interface UserDao extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}

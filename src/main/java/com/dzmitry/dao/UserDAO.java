package com.dzmitry.dao;

import com.dzmitry.entity.User;

public interface UserDAO {

    public User findByName(String username);
    public void save(User user);
}

package com.dzmitry.service;

import com.dzmitry.dao.UserDAO;
import com.dzmitry.entity.User;
import com.dzmitry.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByName(String userName) {
        return null;
    }

    @Override
    public void save(CrmUser crmUser) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

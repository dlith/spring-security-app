package com.dzmitry.service;

import com.dzmitry.entity.User;
import com.dzmitry.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    public User findByName(String userName);
    public void save(CrmUser crmUser);
}

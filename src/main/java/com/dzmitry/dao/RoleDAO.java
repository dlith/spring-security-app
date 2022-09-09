package com.dzmitry.dao;

import com.dzmitry.entity.Role;

public interface RoleDAO {

    public Role findByRoleName(String roleName);
}

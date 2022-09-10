package com.dzmitry.dao;

import com.dzmitry.entity.Role;

public interface RoleDao {

    public Role findByRoleName(String roleName);
}

package com.dzmitry.dao;

import com.dzmitry.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findByRoleName(String roleName) {

        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role where name:=roleName", Role.class);
        query.setParameter("roleName", roleName);
        Role role = null;

        try{
            role = query.getSingleResult();
        }catch (Exception e){
            role = null;
        }

        return role;
    }
}

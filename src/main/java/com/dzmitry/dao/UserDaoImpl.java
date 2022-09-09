package com.dzmitry.dao;

import com.dzmitry.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByName(String username) {

        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where user_name:=username", User.class);
        query.setParameter("username", username);
        User user = null;

        try{
            user = query.getSingleResult();
        }catch (Exception e){
            user = null;
        }

        return user;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}

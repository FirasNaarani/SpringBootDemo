package com.KLA.Orbotech.Framework.Repositorys.User;

import com.KLA.Orbotech.Framework.Entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<User> Get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery("from User", User.class);
       return query.getResultList();
    }
    @Override
    public User Get(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class,id);
    }

    @Override
    public void Create(User newUser) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newUser);
    }

    @Override
    public void Delete(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class,id);
        currentSession.delete(user);
    }
}

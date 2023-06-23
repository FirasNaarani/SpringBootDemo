package com.KLA.Orbotech.Framework.Repositorys.Order;

import com.KLA.Orbotech.Framework.Entity.Order;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepo implements IOrderRepo{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Order> Get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Order> query = currentSession.createQuery("from Order", Order.class);
        return query.getResultList();
    }

    @Override
    public Order Get(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Order.class,id);
    }

    @Override
    public void Create(Order newOrder) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newOrder);
    }

    @Override
    public void Delete(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Order order = currentSession.get(Order.class,id);
        currentSession.delete(order);
    }
}

package com.KLA.Orbotech.Framework.Repositorys.OrderItem;

import com.KLA.Orbotech.Framework.Entity.OrderItem;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepo implements IOrderItemRepo {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<OrderItem> Get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<OrderItem> query = currentSession.createQuery("from OrderItem", OrderItem.class);
        return query.getResultList();
    }

    @Override
    public OrderItem Get(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(OrderItem.class,id);
    }

    @Override
    public void Create(OrderItem newOrderItem) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newOrderItem);
    }

    @Override
    public void Delete(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        OrderItem orderItem = currentSession.get(OrderItem.class,id);
        currentSession.delete(orderItem);
    }
}

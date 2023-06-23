package com.KLA.Orbotech.Framework.Repositorys.Product;

import com.KLA.Orbotech.Framework.Entity.Product;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements IProductRepo{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> Get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Product> query = currentSession.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product Get(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Product.class,id);
    }

    @Override
    public void Create(Product newProduct) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newProduct);
    }

    @Override
    public void Delete(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Product product = currentSession.get(Product.class,id);
        currentSession.delete(product);
    }
}

package com.KLA.Orbotech.Framework.Repositorys.OrderItem;

import com.KLA.Orbotech.Framework.Entity.OrderItem;

import java.util.List;

public interface IOrderItemRepo {
    List<OrderItem> Get();

    OrderItem Get(Integer id);

    void Create(OrderItem newUser);

    void Delete(Integer id);
}

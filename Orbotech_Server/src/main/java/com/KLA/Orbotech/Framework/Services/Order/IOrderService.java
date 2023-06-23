package com.KLA.Orbotech.Framework.Services.Order;

import com.KLA.Orbotech.Framework.Entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> Get();

    Order Get(Integer id);

    void Create(Order newUser);

    void Delete(Integer id);
}

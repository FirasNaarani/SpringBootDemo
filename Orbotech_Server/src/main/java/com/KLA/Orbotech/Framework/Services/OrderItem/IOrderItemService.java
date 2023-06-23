package com.KLA.Orbotech.Framework.Services.OrderItem;

import com.KLA.Orbotech.Framework.Entity.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItem> Get();

    OrderItem Get(Integer id);

    void Create(OrderItem newOrderItem);

    void Delete(Integer id);
}

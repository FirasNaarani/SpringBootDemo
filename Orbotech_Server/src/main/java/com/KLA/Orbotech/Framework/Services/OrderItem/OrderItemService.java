package com.KLA.Orbotech.Framework.Services.OrderItem;

import com.KLA.Orbotech.Framework.Entity.OrderItem;
import com.KLA.Orbotech.Framework.Repositorys.OrderItem.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemService implements IOrderItemService{
    @Autowired
    private OrderItemRepo orderItemRepo;

    @Transactional
    @Override
    public List<OrderItem> Get() {
        return orderItemRepo.Get();
    }

    @Transactional
    @Override
    public OrderItem Get(Integer id) {
        return orderItemRepo.Get(id);
    }

    @Transactional
    @Override
    public void Create(OrderItem newOrderItem) {
        orderItemRepo.Create(newOrderItem);
    }

    @Transactional
    @Override
    public void Delete(Integer id) {
        orderItemRepo.Delete(id);
    }
}

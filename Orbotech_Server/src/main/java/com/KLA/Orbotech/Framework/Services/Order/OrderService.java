package com.KLA.Orbotech.Framework.Services.Order;

import com.KLA.Orbotech.Framework.Entity.Order;
import com.KLA.Orbotech.Framework.Repositorys.Order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Transactional
    @Override
    public List<Order> Get() {
        return orderRepo.Get();
    }

    @Transactional
    @Override
    public Order Get(Integer id) {
        return orderRepo.Get(id);
    }

    @Transactional
    @Override
    public void Create(Order newOrder) {
        orderRepo.Create(newOrder);
    }

    @Transactional
    @Override
    public void Delete(Integer id) {
        orderRepo.Delete(id);
    }
}

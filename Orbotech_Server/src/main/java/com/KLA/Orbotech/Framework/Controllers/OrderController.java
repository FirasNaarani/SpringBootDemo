package com.KLA.Orbotech.Framework.Controllers;

import com.KLA.Orbotech.Framework.Entity.Order;
import com.KLA.Orbotech.Framework.Services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> Get(){
        return orderService.Get();
    }

    @GetMapping("/orders/{id}")
    public Order Get(@PathVariable Integer id){
        Order orderObj = orderService.Get(id);
        if(orderObj != null)
            return orderObj;

        else
            throw new RuntimeException("ORDER WITH ID " + id + " IS NOT FOUND");
    }

    @PostMapping("/orders")
    public Order Create(@RequestBody Order orderObj){
        orderService.Create(orderObj);
        return orderObj;
    }

    @DeleteMapping("/orders/{id}")
    public String Delete(@PathVariable Integer id){
        orderService.Delete(id);
        return "ORDER HAS BEEN DELETED WITH ID :" + id;
    }
}

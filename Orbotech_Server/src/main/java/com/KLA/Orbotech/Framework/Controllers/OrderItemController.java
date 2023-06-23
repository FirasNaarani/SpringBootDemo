package com.KLA.Orbotech.Framework.Controllers;

import com.KLA.Orbotech.Framework.Entity.OrderItem;
import com.KLA.Orbotech.Framework.Services.OrderItem.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderitems")
    public List<OrderItem> Get(){
        return orderItemService.Get();
    }

    @GetMapping("/orderitems/{id}")
    public OrderItem Get(@PathVariable Integer id){
        OrderItem orderItemObj = orderItemService.Get(id);
        if(orderItemObj != null)
            return orderItemObj;

        else
            throw new RuntimeException("ORDER ITEM ITEM WITH ID " + id + " IS NOT FOUND");
    }

    @PostMapping("/orderitems")
    public OrderItem Create(@RequestBody OrderItem orderObj){
        orderItemService.Create(orderObj);
        return orderObj;
    }

    @DeleteMapping("/orderitems/{id}")
    public String Delete(@PathVariable Integer id){
        orderItemService.Delete(id);
        return "ORDER ITEM HAS BEEN DELETED WITH ID :" + id;
    }
}

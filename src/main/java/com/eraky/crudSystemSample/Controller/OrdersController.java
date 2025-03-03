package com.eraky.crudSystemSample.Controller;


import com.eraky.crudSystemSample.entity.Order;
import com.eraky.crudSystemSample.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //create order
    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return ordersService.createOrder(order);
    }

    //get all orders
    @GetMapping
    public List<Order> getALlOrders(){
        return ordersService.findAll();
    }

    //get order by id
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id){
        return ordersService.findById(id);
    }

    //update order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return ordersService.updateOrder(id, updatedOrder);
    }

    //delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        ordersService.deleteOrderById(id);
    }
}

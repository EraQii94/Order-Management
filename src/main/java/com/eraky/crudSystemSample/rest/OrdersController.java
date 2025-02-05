package com.eraky.crudSystemSample.rest;


import com.eraky.crudSystemSample.entity.Orders;
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
    public Orders createOrder(@RequestBody Orders order){
        return ordersService.createOrder(order);
    }

    //get all orders
    @GetMapping
    public List<Orders> getALlOrders(){
        return ordersService.findAll();
    }

    //get order by id
    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable int id){
        return ordersService.findById(id);
    }

    //update order
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable int id, @RequestBody Orders updatedOrder) {
        return ordersService.updateOrder(id, updatedOrder);
    }

    //delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        ordersService.deleteOrderById(id);
    }
}

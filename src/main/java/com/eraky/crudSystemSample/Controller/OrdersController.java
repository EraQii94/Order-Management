package com.eraky.crudSystemSample.Controller;


import com.eraky.crudSystemSample.dto.OrderDTO;
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
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return ordersService.createOrder(orderDTO);
    }

    //get all orders
    @GetMapping
    public List<OrderDTO> getALlOrders(){
        return ordersService.findAll();
    }

    //get order by id
    @GetMapping("/{id}")
    public Optional<OrderDTO> getOrderById(@PathVariable Long id){
        return ordersService.findById(id);
    }

    //update order
    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO updatedOrderDto) {
        return ordersService.updateOrder(id, updatedOrderDto);
    }

    //delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        ordersService.deleteOrderById(id);
    }
}

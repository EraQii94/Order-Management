package com.eraky.crudSystemSample.Controller;


import com.eraky.crudSystemSample.dto.OrderDTO;
import com.eraky.crudSystemSample.entity.Order;
import com.eraky.crudSystemSample.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //create order
    @Operation(summary = "create new order", description = "create new order by passing by order Dto as a request body")
    @ApiResponse(responseCode = "200", description = "CREATED")
    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return ordersService.createOrder(orderDTO);
    }

    //get all orders
    @Operation(summary = "get all orders", description = "retrieving all orders")
    @ApiResponse(responseCode = "200", description = "all orders are retrieved successfully")
    @GetMapping
    public List<OrderDTO> getALlOrders(){
        return ordersService.findAll();
    }

    //get order by id
    @Operation(summary = "get order by id", description = "retrieving order by its id passed as path variable")
    @ApiResponse(responseCode = "200", description = "order found")
    @GetMapping("/{id}")
    public Optional<OrderDTO> getOrderById(@PathVariable Long id){
        return ordersService.findById(id);
    }

    //update order
    @Operation(summary = "update order", description = "updating order by passing the id of order to update and updated order details ")
    @ApiResponse(responseCode = "200", description = "updated successfully")
    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO updatedOrderDto) {
        return ordersService.updateOrder(id, updatedOrderDto);
    }

    //delete order
    @Operation(summary = "delete order", description = "deleting order by passing the id")
    @ApiResponse(responseCode = "200", description = "deleted successfully")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        ordersService.deleteOrderById(id);
    }
}

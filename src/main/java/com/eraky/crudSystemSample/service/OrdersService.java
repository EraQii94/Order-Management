package com.eraky.crudSystemSample.service;

import com.eraky.crudSystemSample.Repository.OrdersRepository;
import com.eraky.crudSystemSample.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired //field injection
    private OrdersRepository ordersRepository;


    //create
    public Order createOrder(Order order){
        return ordersRepository.save(order);
    }

    //read all
    public List<Order> findAll(){
        return ordersRepository.findAll();
    }

    //read By ID
    public Optional<Order> findById(int id){
        return ordersRepository.findById(id);
    }

    //update
    public Order updateOrder(int id, Order updatedOrder){
        if (ordersRepository.existsById(id)) {
            updatedOrder.setId(id);
            return updatedOrder;
        }
        return null;
    }

    //delete
    public void deleteOrderById(int id){
        ordersRepository.deleteById(id);

    }
}

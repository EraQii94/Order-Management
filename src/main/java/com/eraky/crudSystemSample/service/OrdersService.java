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
    public Optional<Order> findById(Long id){
        Optional<Order> tempOrder = ordersRepository.findById(id);
        return tempOrder;
    }

    //update
    public Order updateOrder(Long id, Order updatedOrder) {

        Optional<Order> tempOrder = ordersRepository.findById(id);

        if (tempOrder.isPresent()) {
            Order existingOrder = tempOrder.get();

            existingOrder.setProductName(updatedOrder.getProductName());
            existingOrder.setPrice(updatedOrder.getPrice());
            existingOrder.setQuantity(updatedOrder.getQuantity());


            return ordersRepository.save(existingOrder);
        } else {

            return null;
        }
    }

    //delete
    public void deleteOrderById(Long id){
        ordersRepository.deleteById(id);

    }
}

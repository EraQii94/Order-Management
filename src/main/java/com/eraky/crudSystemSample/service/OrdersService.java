package com.eraky.crudSystemSample.service;

import com.eraky.crudSystemSample.DAO.OrdersRepository;
import com.eraky.crudSystemSample.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired //field injection
    private OrdersRepository ordersRepository;


    //create
    public Orders createOrder(Orders order){
        return ordersRepository.save(order);
    }

    //read all
    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    //read By ID
    public Optional<Orders> findById(int id){
        return ordersRepository.findById(id);
    }

    //update
    public Orders updateOrder(int id, Orders updatedOrder){
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

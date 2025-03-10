package com.eraky.crudSystemSample.service;

import com.eraky.crudSystemSample.Repository.OrdersRepository;
import com.eraky.crudSystemSample.dto.OrderDTO;
import com.eraky.crudSystemSample.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired //field injection
    private OrdersRepository ordersRepository;


    private Order convertToEntity(OrderDTO orderDTO){
        Order order =new Order();

        order.setProductName(orderDTO.getProductName());
        order.setPrice(orderDTO.getPrice());
        order.setQuantity(orderDTO.getQuantity());

        return order;
    }

    private OrderDTO convertToDto(Order order){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setProductName(order.getProductName());
        orderDTO.setPrice(order.getPrice());
        orderDTO.setQuantity(order.getQuantity());

        return orderDTO;
    }



    //create
    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order=convertToEntity(orderDTO);
        Order savedOrder = ordersRepository.save(order);
        return convertToDto(savedOrder);
    }

    //read all
    public List<OrderDTO> findAll(){
        List<Order> orders = ordersRepository.findAll();
        //map بتاخد كل عنصر في الستريم وتنفذ عليه الميثود اللي جواها
        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    //read By ID
    public Optional<OrderDTO> findById(Long id){
        Optional<Order> tempOrder = ordersRepository.findById(id);
        return tempOrder.map(this::convertToDto);
    }

    //update
    public OrderDTO updateOrder(Long id, OrderDTO updatedOrderDto) {

        Optional<Order> tempOrder = ordersRepository.findById(id);

        if (tempOrder.isPresent()) {
            Order existingOrder = tempOrder.get();

            existingOrder.setProductName(updatedOrderDto.getProductName());
            existingOrder.setPrice(updatedOrderDto.getPrice());
            existingOrder.setQuantity(updatedOrderDto.getQuantity());

            Order updatedOrder = ordersRepository.save(existingOrder);
            return convertToDto(updatedOrder);
        } else {

            return null;
        }
    }

    //delete
    public void deleteOrderById(Long id){
        ordersRepository.deleteById(id);

    }
}

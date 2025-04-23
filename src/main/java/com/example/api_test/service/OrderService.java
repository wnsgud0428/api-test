package com.example.api_test.service;

import com.example.api_test.model.Order;
import com.example.api_test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOrder(long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    // update는 saveOrder 로 대체

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }


}

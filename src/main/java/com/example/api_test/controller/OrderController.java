package com.example.api_test.controller;

import com.example.api_test.model.Order;
import com.example.api_test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order insertOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }


}

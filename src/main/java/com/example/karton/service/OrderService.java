package com.example.karton.service;



import com.example.karton.model.Order;
import com.example.karton.model.User;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order save(Order order);

    List<Order> findOrderByUser(User user);
}

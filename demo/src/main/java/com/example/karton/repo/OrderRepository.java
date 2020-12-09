package com.example.karton.repo;

import com.example.karton.model.Order;
import com.example.karton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order,Long> {
    List<Order> findOrderByUser(User user);
}

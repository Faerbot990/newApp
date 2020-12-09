package com.example.karton.controller;



import com.example.karton.model.Order;
import com.example.karton.model.User;

import com.example.karton.service.OrderService;
import com.example.karton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }
    @GetMapping("/user/edit")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal User userSession) {
        User user = userService.findByUsername(userSession.getUsername());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    @GetMapping("/user/orders")
    public ResponseEntity<?> getAllUserOrders(@AuthenticationPrincipal User userSession) {
        User user = userService.findByUsername(userSession.getUsername());
        List<Order> orders = orderService.findOrderByUser(user);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

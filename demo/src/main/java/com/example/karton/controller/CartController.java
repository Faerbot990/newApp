package com.example.karton.controller;


import com.example.karton.model.Product;
import com.example.karton.model.User;
import com.example.karton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class CartController {

    private final UserService userService;

    @Autowired
    public CartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(@AuthenticationPrincipal User userSession) {
        User user = userService.findByUsername(userSession.getUsername());
        List<Product> productList = user.getProductList();

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToCart(@RequestBody Product product, @AuthenticationPrincipal User userSession) {
        User user = userService.findByUsername(userSession.getUsername());
        user.getProductList().add(product);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cart/remove")
    public ResponseEntity<?> removeFromCart(@RequestBody Product product, @AuthenticationPrincipal User userSession) {
        User user = userService.findByUsername(userSession.getUsername());
        user.getProductList().add(product);



        List<Product> productList = user.getProductList();

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}

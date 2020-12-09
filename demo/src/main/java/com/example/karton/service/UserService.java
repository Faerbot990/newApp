package com.example.karton.service;



import com.example.karton.model.User;

import java.util.List;


public interface UserService {
    User getOne(Long id);

    List<User> findAll();

    User findByUsername(String username);

}

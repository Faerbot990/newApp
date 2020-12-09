package com.example.karton.repo;


import com.example.karton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Override
    User getOne(Long aLong);
}

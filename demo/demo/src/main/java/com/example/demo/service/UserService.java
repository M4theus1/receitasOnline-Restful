package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity getUserById(Integer id);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(Integer id, UserEntity userDetails);
    void deleteUser(Integer id);
    boolean existsByEmail(String email);
}
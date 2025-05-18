package com.example.demo.service;

import com.example.demo.dto.UserResponse;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repositoryUser;

    public UserService(UserRepository repository) {
        this.repositoryUser = repository;
    }

    public void createUser(UserEntity user) {
        repositoryUser.save(user);
    }

    public Page<UserEntity> getUsers(Pageable pageable) {
        return findAll();
    }

    public Page<UserEntity> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
                repositoryUser.findAll(),
                pageRequest, size);
    }

    public UserResponse getUser(Long id) {
        return repositoryUser.findById(id)
                .map(u -> new UserResponse(u.getName()))
                .orElseThrow(() -> new NotFoundException("Usuario nao encontrado."));
    }

    public void updateUser(Long id, UserEntity user) {
        var userEntity = getUser(id);

        if (userEntity != null) {
//            userEntity.setName(user.getName());
//            userEntity.setEmail(user.getEmail());
//            repository.save(userEntity);
        }
    }

    public void deleteUser(Long id) {
        var user = getUser(id);

        if (user != null) {
//            repository.delete(user);
        }
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.exception.ResourceNotFoundException;
import com.example.demo.model.exception.BusinessException;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserEntity createUser(UserEntity user) {
        // Validação de email único
        if (existsByEmail(user.getEmail())) {
            throw new BusinessException("Email já está em uso: " + user.getEmail());
        }

        // Validações adicionais podem ser feitas aqui
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new BusinessException("Nome do usuário é obrigatório");
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity updateUser(Integer id, UserEntity userDetails) {
        UserEntity user = getUserById(id); // Já lança exceção se não existir

        // Verifica se o novo email já está em uso por outro usuário
        if (userDetails.getEmail() != null &&
                !userDetails.getEmail().equals(user.getEmail()) &&
                existsByEmail(userDetails.getEmail())) {
            throw new BusinessException("Email já está em uso: " + userDetails.getEmail());
        }

        // Atualiza apenas os campos não nulos
        if (userDetails.getName() != null) {
            user.setName(userDetails.getName());
        }
        if (userDetails.getEmail() != null) {
            user.setEmail(userDetails.getEmail());
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        UserEntity user = getUserById(id); // Verifica se existe
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
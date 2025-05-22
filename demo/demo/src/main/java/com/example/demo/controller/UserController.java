package com.example.demo.controller;

import com.example.demo.model.dto.UserRequestDTO;
import com.example.demo.model.dto.UserResponseDTO;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        UserEntity savedUser = userService.createUser(user);
        return new ResponseEntity<>(new UserResponseDTO(savedUser), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(new UserResponseDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers().stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Integer id,
            @RequestBody UserRequestDTO userDTO) {
        UserEntity userDetails = new UserEntity();
        userDetails.setName(userDTO.getName());
        userDetails.setEmail(userDTO.getEmail());

        UserEntity updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(new UserResponseDTO(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
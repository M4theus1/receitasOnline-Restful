package com.example.demo.model.dto;

import com.example.demo.model.entity.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta para usuário")
public class UserResponseDTO {

        @Schema(description = "ID do usuário", example = "1")
        private Integer id;

        @Schema(description = "Nome completo do usuário", example = "Maria Souza")
        private String name;

        @Schema(description = "Email do usuário", example = "maria@email.com")
        private String email;

        // getters e setters


        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        // Construtor que recebe UserEntity
        public UserResponseDTO(UserEntity user) {
                this.id = user.getId();
                this.name = user.getName();
                this.email = user.getEmail();
        }
}
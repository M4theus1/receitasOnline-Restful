package com.example.demo.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ReceitaRequestDTO {

    @NotBlank(message = "Titulo é obrigatório")
    @Schema(description = "Título da receita", example = "Bolo de Cenoura")
    String titulo;

    @NotBlank(message = "Descrição é obrigatório")
    @Schema(description = "Descrição da receita", example = "Um bolo delicioso para o café da tarde.")
    String descricao;

    @NotBlank(message = "Modo de Preparo é obrigatório")
    @Schema(description = "Modo de preparo da receita", example = "Misture tudo e leve ao forno por 40 minutos.")
    String modoPreparo;

    @NotBlank(message = "Os ingredientes são obrigatórios")
    @Schema(description = "Lista de ingredientes", example = "[\"2 cenouras\", \"2 ovos\", \"1 xícara de açúcar\"]")
    List<String> ingredientes;

    //getters e setters


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}

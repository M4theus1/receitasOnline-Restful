package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO para criação de uma avaliação")
public class AvaliacaoRequestDTO {

    @NotNull(message = "ID do usuário é obrigatório")
    @Schema(description = "ID do usuário que está avaliando", example = "1")
    private Integer userId;

    @NotNull(message = "ID da receita é obrigatório")
    @Schema(description = "ID da receita que está sendo avaliada", example = "10")
    private Integer receitaId;

    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    @Schema(description = "Nota de 1 a 5", example = "5")
    private int nota;

    @Size(max = 1000, message = "O comentário pode ter no máximo 1000 caracteres")
    @Schema(description = "Comentário da avaliação", example = "Receita maravilhosa! Fácil de seguir e muito saborosa.")
    private String comentario;

    // Getters e Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(Integer receitaId) {
        this.receitaId = receitaId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de uma avaliação")
public record AvaliacaoResponse(

        @Schema(description = "ID da avaliação", example = "101")
        Integer id,

        @Schema(description = "ID do usuário que fez a avaliação", example = "5")
        Integer userId,

        @Schema(description = "Nome do usuário que fez a avaliação", example = "João da Silva")
        String userName,

        @Schema(description = "Nota atribuída, de 1 a 5", example = "4")
        int nota,

        @Schema(description = "Comentário adicional da avaliação", example = "Receita maravilhosa!")
        String comentario

) {}

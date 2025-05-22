package com.example.demo.model.dto;

import com.example.demo.model.dto.ReceitaComAutorResponseDTO;
import com.example.demo.model.entity.AvaliacaoEntity;
import com.example.demo.model.entity.ReceitaEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta para receitas completas")
public class ReceitaResponseDTO {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Schema(description = "Lista de receitas com informações do autor")
        private List<ReceitaComAutorResponseDTO> receitas;

        @Schema(description = "Título da Receita", example = "Bolo de Cenoura")
        private String titulo;

        @Schema(description = "Descrição da Receita", example = "Deliciosa receita de bolo de cenoura")
        private String descricao;

        @Schema(description = "Modo de Preparo", example = "Misturar a massa e assar durante 30 minutos")
        private String modoPreparo;

        @Schema(description = "Lista de ingredientes", example = "[\"Cenoura\", \"Farinha\", \"Ovos\"]")
        private List<String> ingredientes;

        @Schema(description = "Avaliações da receita")
        private List<AvaliacaoResponseDTO> avaliacoes; // Sugiro usar um DTO específico para avaliações

        // Construtor para lista de receitas
        public ReceitaResponseDTO(List<ReceitaComAutorResponseDTO> receitas) {
                this.receitas = receitas;
        }

        // Construtor para detalhes de uma receita
        public ReceitaResponseDTO(ReceitaEntity receitaEntity) {
                this.titulo = receitaEntity.getTitulo();
                this.descricao = receitaEntity.getDescricao();
                this.modoPreparo = receitaEntity.getModoPreparo();
                this.ingredientes = receitaEntity.getIngredientes();
                this.avaliacoes = List.of();
        }

}
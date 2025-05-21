package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "DTO de resposta para múltiplas receitas")
public class ReceitasResponseDTO {

        @Schema(description = "Lista de receitas")
        private List<ReceitaComAutorResponseDTO> receitas;

        public ReceitasResponseDTO(List<ReceitaComAutorResponseDTO> receitas) {
                this.receitas = receitas;
        }

        public List<ReceitaComAutorResponseDTO> getReceitas() {
                return receitas;
        }

        public void setReceitas(List<ReceitaComAutorResponseDTO> receitas) {
                this.receitas = receitas;
        }
}

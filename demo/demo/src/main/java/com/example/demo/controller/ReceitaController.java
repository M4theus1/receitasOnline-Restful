    package com.example.demo.controller;

    import com.example.demo.model.dto.ReceitaRequestDTO;
    import com.example.demo.model.dto.ReceitaResponseDTO;
    import com.example.demo.model.entity.ReceitaEntity;
    import com.example.demo.service.ReceitaService;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import jakarta.validation.Valid;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/api/receitas")
    @Tag(name = "Receitas", description = "Operações relacionadas às receitas")
    public class ReceitaController {

        private final ReceitaService receitaService;

        public ReceitaController(ReceitaService receitaService) {
            this.receitaService = receitaService;
        }

        @PostMapping
        public ResponseEntity<ReceitaResponseDTO> createReceita(@RequestBody @Valid ReceitaRequestDTO receitaDTO) {
            ReceitaEntity receita = new ReceitaEntity();
            receita.setTitulo(receitaDTO.getTitulo());
            receita.setDescricao(receitaDTO.getDescricao());
            receita.setIngredientes(receitaDTO.getIngredientes());
            receita.setModoPreparo(receitaDTO.getModoPreparo());

            receita.setAvaliacoes(List.of());

            ReceitaEntity savedReceita = receitaService.createReceita(receita);
            ReceitaResponseDTO responseDTO = new ReceitaResponseDTO(savedReceita);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ReceitaResponseDTO> getReceitaById(@PathVariable Integer id) {
            ReceitaEntity receita = receitaService.getReceitaById(id);
            return ResponseEntity.ok(new ReceitaResponseDTO(receita));
        }

        @GetMapping
        public ResponseEntity<List<ReceitaResponseDTO>> getAllReceitas() {
            List<ReceitaResponseDTO> receitas = receitaService.getAllReceitas().stream()
                    .map(ReceitaResponseDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(receitas);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ReceitaResponseDTO> updateReceita(
                @PathVariable Integer id,
                @RequestBody @Valid ReceitaRequestDTO receitaDTO) {
            ReceitaEntity receitaDetails = new ReceitaEntity();
            receitaDetails.setTitulo(receitaDTO.getTitulo());
            receitaDetails.setDescricao(receitaDTO.getDescricao());
            receitaDetails.setIngredientes(receitaDTO.getIngredientes());
            receitaDetails.setModoPreparo(receitaDTO.getModoPreparo());

            ReceitaEntity updatedReceita = receitaService.updateReceita(id, receitaDetails);
            return ResponseEntity.ok(new ReceitaResponseDTO(updatedReceita));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReceita(@PathVariable Integer id) {
            receitaService.deleteReceita(id);
            return ResponseEntity.noContent().build();
        }
    }

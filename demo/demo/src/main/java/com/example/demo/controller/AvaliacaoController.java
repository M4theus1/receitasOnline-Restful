package com.example.demo.controller;

import com.example.demo.model.dto.AvaliacaoRequestDTO;
import com.example.demo.model.dto.AvaliacaoResponseDTO;
import com.example.demo.model.entity.AvaliacaoEntity;
import com.example.demo.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/avaliacoes")
@Tag(name = "Avaliações", description = "O usuário poderá listar as avaliações geradas pelos demais usuários. Criar e editar avaliações também são atributos desse controller.")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> createAvaliacao(@RequestBody @Valid AvaliacaoRequestDTO requestDTO) {
        AvaliacaoEntity novaAvaliacao = avaliacaoService.createAvaliacao(requestDTO);
        return new ResponseEntity<>(new AvaliacaoResponseDTO(novaAvaliacao), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> getAllAvaliacoes() {
        List<AvaliacaoResponseDTO> avaliacoes = avaliacaoService.getAllAvaliacoes()
                .stream()
                .map(AvaliacaoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> getAvaliacaoById(@PathVariable Integer id) {
        AvaliacaoEntity avaliacao = avaliacaoService.getAvaliacaoById(id);
        return ResponseEntity.ok(new AvaliacaoResponseDTO(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> updateAvaliacao(@PathVariable Integer id,
                                                                @RequestBody @Valid AvaliacaoRequestDTO requestDTO) {
        AvaliacaoEntity updated = avaliacaoService.updateAvaliacao(id, requestDTO);
        return ResponseEntity.ok(new AvaliacaoResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Integer id) {
        avaliacaoService.deleteAvaliacao(id);
        return ResponseEntity.noContent().build();
    }
}

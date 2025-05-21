package com.example.demo.controller;

import com.example.demo.model.dto.ReceitaRequestDTO;
import com.example.demo.model.dto.ReceitasResponseDTO;
import com.example.demo.model.entity.ReceitaEntity;
import com.example.demo.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

}

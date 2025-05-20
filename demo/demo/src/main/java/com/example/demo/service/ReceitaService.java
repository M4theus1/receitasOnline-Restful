package com.example.demo.service;

import com.example.demo.dto.ReceitaResponse;
import com.example.demo.entity.ReceitaEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    private final ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    public void createReceita(ReceitaEntity receita) {
        repository.save(receita);
    }

    public Page<ReceitaEntity> getReceitas() {
        return findAll();
    }

    private Page<ReceitaEntity> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "titulo");
        return new PageImpl<>(repository.findAll(), pageRequest, size);
    }

    public ReceitaResponse getReceita(Long id) {
        return repository.findById(id)
                .map(receita -> new ReceitaResponse(receita.getTitulo()))
                .orElseThrow(() -> new NotFoundException("Receita não encontrada."));
    }

    // Você pode adicionar update e delete, se quiser
}

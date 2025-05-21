package com.example.demo.service;

import com.example.demo.dto.AvaliacaoResponse;
import com.example.demo.entity.AvaliacaoEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.AvaliacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public void createAvaliacao(AvaliacaoEntity avaliacao) {
        repository.save(avaliacao);
    }

    public Page<AvaliacaoEntity> getAvaliacoes() {
        return findAll();
    }

    private Page<AvaliacaoEntity> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "titulo"); // Ajuste o campo se necessário
        return new PageImpl<>(repository.findAll(), pageRequest, size);
    }

    public AvaliacaoResponse getAvaliacao(Long id) {
        return repository.findById(id)
                .map(avaliacao -> new AvaliacaoResponse(avaliacao.getComentario()))
                .orElseThrow(() -> new NotFoundException("Avaliação não encontrada."));
    }

    // Também pode incluir update e delete aqui
}

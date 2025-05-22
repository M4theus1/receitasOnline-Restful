package com.example.demo.service;

import com.example.demo.model.dto.AvaliacaoRequestDTO;
import com.example.demo.model.entity.AvaliacaoEntity;

import java.util.List;

public interface AvaliacaoService {

    AvaliacaoEntity createAvaliacao(AvaliacaoRequestDTO requestDTO);
    List<AvaliacaoEntity> getAllAvaliacoes();
    AvaliacaoEntity getAvaliacaoById(Integer id);
    AvaliacaoEntity updateAvaliacao(Integer id, AvaliacaoRequestDTO requestDTO);
    void deleteAvaliacao(Integer id);
}

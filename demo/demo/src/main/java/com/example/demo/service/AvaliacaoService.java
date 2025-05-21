package com.example.demo.service;

import com.example.demo.model.entity.AvaliacaoEntity;
import java.util.List;

public interface AvaliacaoService {
    AvaliacaoEntity createAvaliacao(AvaliacaoEntity avaliacao);
    AvaliacaoEntity getAvaliacaoById(Integer id);
    List<AvaliacaoEntity> getAllAvaliacoes();
    AvaliacaoEntity updateAvaliacao(Integer id, AvaliacaoEntity avaliacaoDetails);
    void deleteAvaliacao(Integer id);
}
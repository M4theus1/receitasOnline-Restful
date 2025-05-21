package com.example.demo.service;

import com.example.demo.model.entity.ReceitaEntity;

import java.util.List;

public interface ReceitaService {

    ReceitaEntity createReceita(ReceitaEntity receita);

    ReceitaEntity getReceitaById(Integer id);

    List<ReceitaEntity> getAllReceitas();

    ReceitaEntity updateReceita(Integer id, ReceitaEntity receitaDetails);

    void deleteReceita(Integer id);
}

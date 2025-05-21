package com.example.demo.service.impl;

import com.example.demo.model.entity.ReceitaEntity;
import com.example.demo.model.exception.ResourceNotFoundException;
import com.example.demo.model.exception.BusinessException;
import com.example.demo.repository.ReceitaRepository;
import com.example.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceitaServiceImpl implements ReceitaService {
    private final ReceitaRepository receitaRepository;

    @Autowired
    public ReceitaServiceImpl(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    @Transactional
    public ReceitaEntity createReceita(ReceitaEntity receita) {
        if (receita.getTitulo() == null || receita.getTitulo().trim().isEmpty()) {
            throw new BusinessException("Título da receita é obrigatório");
        }

        return receitaRepository.save(receita);
    }

    @Override
    @Transactional(readOnly = true)
    public ReceitaEntity getReceitaById(Integer id) {
        return receitaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReceitaEntity> getAllReceitas() {
        return receitaRepository.findAll();
    }

    @Override
    @Transactional
    public ReceitaEntity updateReceita(Integer id, ReceitaEntity receitaDetails) {
        ReceitaEntity receita = getReceitaById(id); //Já lança exceção se não existir

        //Atualiza apenas os campos não nulos
        if (receitaDetails.getTitulo() != null) {
            receita.setTitulo(receitaDetails.getTitulo());
        }
        if(receitaDetails.getDescricao() != null) {
            receita.setDescricao(receitaDetails.getDescricao());
        }

        return receitaRepository.save(receita);
    }

    @Override
    @Transactional
    public void deleteReceita(Integer id) {
        ReceitaEntity receita = getReceitaById(id); //Verifica se existe
        receitaRepository.delete(receita);
    }


}

package com.example.demo.service.impl;

import com.example.demo.model.entity.ReceitaEntity;
import com.example.demo.model.exception.ResourceNotFoundException;
import com.example.demo.model.exception.BusinessException;
import com.example.demo.model.entity.AvaliacaoEntity;
import com.example.demo.repository.AvaliacaoRepository;
import com.example.demo.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    @Transactional
    public AvaliacaoEntity createAvaliacao(AvaliacaoEntity avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    @Transactional(readOnly = true)
    public AvaliacaoEntity getAvaliacaoById(Integer id){
        return avaliacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrado com ID: " + id));

    }

    @Override
    @Transactional(readOnly = true)
    public List<AvaliacaoEntity> getAllAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    @Override
    @Transactional
    public AvaliacaoEntity updateAvaliacao(Integer id, AvaliacaoEntity avaliacaoDetails){
        AvaliacaoEntity avaliacao = getAvaliacaoById(id);

        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    @Transactional
    public void deleteAvaliacao(Integer id){
        AvaliacaoEntity avaliacao = getAvaliacaoById(id);
        avaliacaoRepository.delete(avaliacao);
    }
}

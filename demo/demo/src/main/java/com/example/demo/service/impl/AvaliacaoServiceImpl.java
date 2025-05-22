package com.example.demo.service.impl;

import com.example.demo.model.dto.AvaliacaoRequestDTO;
import com.example.demo.model.entity.AvaliacaoEntity;
import com.example.demo.model.entity.ReceitaEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.AvaliacaoRepository;
import com.example.demo.repository.ReceitaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AvaliacaoService;
import com.example.demo.model.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ReceitaRepository receitaRepository;
    private final UserRepository userRepository;

    public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository,
                                ReceitaRepository receitaRepository,
                                UserRepository userRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.receitaRepository = receitaRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public AvaliacaoEntity createAvaliacao(AvaliacaoRequestDTO requestDTO) {
        ReceitaEntity receita = receitaRepository.findById(requestDTO.getReceitaId())
                .orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com ID: " + requestDTO.getReceitaId()));

        UserEntity user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + requestDTO.getUserId()));

        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setReceita(receita);
        avaliacao.setUser(user);
        avaliacao.setNota(requestDTO.getNota());
        avaliacao.setComentario(requestDTO.getComentario());

        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AvaliacaoEntity> getAllAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AvaliacaoEntity getAvaliacaoById(Integer id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada com ID: " + id));
    }

    @Override
    @Transactional
    public AvaliacaoEntity updateAvaliacao(Integer id, AvaliacaoRequestDTO requestDTO) {
        AvaliacaoEntity avaliacao = getAvaliacaoById(id);

        if (requestDTO.getNota() != 0) {
            avaliacao.setNota(requestDTO.getNota());
        }
        if (requestDTO.getComentario() != null) {
            avaliacao.setComentario(requestDTO.getComentario());
        }
        // Opções para alterar receita e user também podem ser implementadas aqui, se desejado.

        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    @Transactional
    public void deleteAvaliacao(Integer id) {
        AvaliacaoEntity avaliacao = getAvaliacaoById(id);
        avaliacaoRepository.delete(avaliacao);
    }
}

package com.example.demo.repository;

import com.example.demo.model.entity.AvaliacaoEntity;
import com.example.demo.model.entity.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Integer> {

    //Retornar avaliações de uma receita específica
    List<AvaliacaoEntity> findByReceita(ReceitaEntity receita);
}

package com.example.demo.model.dto;

import com.example.demo.model.entity.AvaliacaoEntity;

public class AvaliacaoResponseDTO {

    private Integer id;
    private String nomeUsuario;
    private int nota;
    private String comentario;

    public AvaliacaoResponseDTO() {}

    public AvaliacaoResponseDTO(AvaliacaoEntity avaliacaoEntity) {
        this.id = avaliacaoEntity.getId();
        this.nomeUsuario = avaliacaoEntity.getUser() != null ? avaliacaoEntity.getUser().getName() : "Usuário desconhecido";
        this.nota = avaliacaoEntity.getNota();
        this.comentario = avaliacaoEntity.getComentario();
    }

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

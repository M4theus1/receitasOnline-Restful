package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Dados de uma receita com informações do autor")
public class ReceitaComAutorResponseDTO {

    @Schema(description = "ID da receita", example = "1")
    private Integer id;

    @Schema(description = "Título da receita", example = "Bolo de Cenoura")
    private String titulo;

    @Schema(description = "Descrição da receita", example = "Um bolo delicioso para o café da tarde.")
    private String descricao;

    @Schema(description = "Modo de preparo da receita", example = "Misture tudo e leve ao forno por 40 minutos.")
    private String modoPreparo;

    @Schema(description = "Lista de ingredientes", example = "[\"2 cenouras\", \"2 ovos\", \"1 xícara de açúcar\"]")
    private List<String> ingredientes;

    @Schema(description = "Avaliações feitas para esta receita")
    private List<AvaliacaoResponseDTO> avaliacoes;

    @Schema(description = "Autor da receita")
    private UserResponseDTO autor;

    // Getters, setters e construtor

    public ReceitaComAutorResponseDTO(Integer id, String titulo, String descricao, String modoPreparo, List<String> ingredientes, List<AvaliacaoResponseDTO> avaliacoes, UserResponseDTO autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.modoPreparo = modoPreparo;
        this.ingredientes = ingredientes;
        this.avaliacoes = avaliacoes;
        this.autor = autor;
    }

    public Integer getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getModoPreparo() { return modoPreparo; }
    public List<String> getIngredientes() { return ingredientes; }
    public List<AvaliacaoResponseDTO> getAvaliacoes() { return avaliacoes; }
    public UserResponseDTO getAutor() { return autor; }

    public void setId(Integer id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setModoPreparo(String modoPreparo) { this.modoPreparo = modoPreparo; }
    public void setIngredientes(List<String> ingredientes) { this.ingredientes = ingredientes; }
    public void setAvaliacoes(List<AvaliacaoResponseDTO> avaliacoes) { this.avaliacoes = avaliacoes; }
    public void setAutor(UserResponseDTO autor) { this.autor = autor; }
}

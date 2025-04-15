/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.entity;

/**
 *
 * @author Julia
 */
public class CidadeDTO {
    
    private int idCatastrofe;
    private String ano;
    private String titulo;
    private String descricao;

    public CidadeDTO() {
    }

    public CidadeDTO(int idCatastrofe, String ano, String titulo, String descricao) {
        this.idCatastrofe = idCatastrofe;
        this.ano = ano;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIdCatastrofe() {
        return idCatastrofe;
    }

    public void setIdCatastrofe(int idCatastrofe) {
        this.idCatastrofe = idCatastrofe;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

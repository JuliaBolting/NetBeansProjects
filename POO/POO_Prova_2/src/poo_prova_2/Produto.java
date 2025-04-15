/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_2;

import java.time.LocalDate;

/**
 *
 * @author Julia
 */
public class Produto {
    private String nome;
    private float preco;
    private LocalDate dataAquisicao;

    public Produto() {
    }

    public Produto(String nome, float preco, LocalDate dataAquisicao) {
        this.nome = nome;
        this.preco = preco;
        this.dataAquisicao = dataAquisicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + ", dataAquisicao=" + dataAquisicao + '}';
    }
    
}

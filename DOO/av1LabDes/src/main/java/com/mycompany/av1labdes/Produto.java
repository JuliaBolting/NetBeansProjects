/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.av1labdes;

/**
 *
 * @author Julia
 */
public class Produto {
    private String Nome;
    private double preco;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "Nome=" + Nome + ", preco=" + preco + '}';
    }

    public void exibirDescricao() {
        System.out.println("Produto: " + Nome + " | Preço R$ " + String.format("%.2f", preco));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.generics;

/**
 *
 * @author alunolages
 */
public class Produto {
    private String titulo;
    private double preco;

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }
    
    public Produto(String t, double valor){
        this.titulo = t;
        this.preco = valor;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reflection;

/**
 *
 * @author alunolages
 */
public class Personagem {
    
    private String nome;
    private int ataque;
    private int defesa;

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void aumentarDano(int ponto) {
        this.ataque += ponto;
    }        
    
    public Personagem(String n, int a, int d){
        this.nome = n;
        this.ataque = a;
        this.defesa = d;
    }
    
    public int atacar(){
        return this.ataque;
    }
    
    public void defender(){
        
    }
    
}

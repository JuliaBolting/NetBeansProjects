/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio7;

import java.time.LocalDate;

/**
 *
 * @author Julia
 */
public class Participante {
    private String nome;
    private LocalDate datanasc;
    
    public Participante(){}

    public Participante(String nome, LocalDate datanasc) {
        this.nome = nome;
        this.datanasc = datanasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }
    
    
    
}

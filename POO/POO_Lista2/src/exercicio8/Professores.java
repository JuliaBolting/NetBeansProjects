/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio8;

/**
 *
 * @author Julia
 */
public class Professores {
    private String nome;
    private String titulacao;

    public Professores(){}
    
    public Professores(String nome, String titulacao) {
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    
}

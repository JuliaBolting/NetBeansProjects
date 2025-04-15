/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio10;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Turma {
    private String nome;
    private ArrayList<Aluno> listAluno = new ArrayList();

    public Turma() {
    }

    public Turma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getListAluno() {
        return listAluno;
    }

    public void setListAluno(ArrayList<Aluno> listAluno) {
        this.listAluno = listAluno;
    }
    
    
    
}

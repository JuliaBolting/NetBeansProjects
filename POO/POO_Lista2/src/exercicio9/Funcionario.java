/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio9;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Funcionario {
    private String nome;
    private String sexo;
    private Float salario;
    private ArrayList<Dependente> listDepen = new ArrayList();

    public Funcionario() {
    }

    public Funcionario(String nome, String sexo, Float salario) {
        this.nome = nome;
        this.sexo = sexo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public ArrayList<Dependente> getListDepen() {
        return listDepen;
    }

    public void setListDepen(ArrayList<Dependente> listDepen) {
        this.listDepen = listDepen;
    }
    
    
    
}

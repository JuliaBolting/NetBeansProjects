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
public class Empresa {
    private String nome;
    private ArrayList<Funcionario> listaFun = new ArrayList();

    public Empresa() {
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Funcionario> getListaFun() {
        return listaFun;
    }

    public void setListaFun(ArrayList<Funcionario> listaFun) {
        this.listaFun = listaFun;
    }
    
    
    
    
}

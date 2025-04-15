/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_3;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Pessoa{
    private String nome;
    private ArrayList<Terrestre> listTerr = new ArrayList();

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Terrestre> getListTerr() {
        return listTerr;
    }

    public void setListTerr(ArrayList<Terrestre> listTerr) {
        this.listTerr = listTerr;
    }

    public void addTerrList(Terrestre terrestre) {
        listTerr.add(terrestre);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", listTerr=" + listTerr + '}';
    }
    
}

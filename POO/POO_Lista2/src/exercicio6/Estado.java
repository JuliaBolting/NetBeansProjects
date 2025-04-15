/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio6;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Estado {

    private String nome;
    private String sigla;
    private ArrayList<Cidade> listaCidades = new ArrayList();

    public Estado() {
    }

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.listaCidades = new ArrayList();
    }

    public Estado(String nome, String sigla, ArrayList<Cidade> listaCidades) {
        this.nome = nome;
        this.sigla = sigla;
        this.listaCidades = listaCidades;
        this.listaCidades = new ArrayList();
    }

    public ArrayList<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(ArrayList<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String returnMaiorPop(int populacao) {
        String ret = "";
        for (Cidade pop : this.listaCidades) {
            if (pop.getPopulacao() == populacao) {
                ret = ("Maior População: " + pop.getPopulacao() + " na cidade " + pop.getNome());
            }
        }
        return ret;
    }

    public int returnQuantClima(String clima) {
        int ret = 0;
        for (Cidade clim : this.listaCidades) {
            if (clim.getClima().equals(clima)) {
                ret = ret+1;
            }
        }
        return ret;
    }
    
    public String returnCidades(ArrayList<Cidade> cidades){
        //int size = cidades.size();
        
        String cid = "";
        for(Cidade list : cidades){
            cid = cid + list.getNome() + " "+ list.getClima() + " "+ list.getArea() + " "+ list.getPopulacao();
            cid = cid + "  /  ";
        }
        return cid;
    }
    
    public void addCidadeList(Cidade cidade){
        listaCidades.add(cidade);
    }

    @Override
    public String toString() {
        return "Estado{" + "nome=" + nome + ", sigla=" + sigla + ", listaCidades=" + returnCidades(listaCidades) + '}';
    }

}

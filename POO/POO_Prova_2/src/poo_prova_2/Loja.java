/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Loja {

    private String nome;
    private ArrayList<Produto> listPro = new ArrayList();

    public Loja() {
    }

    public Loja(String nome, ArrayList<Produto> listPro) {
        this.nome = nome;
        this.listPro = listPro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getListPro() {
        return listPro;
    }

    public void setListPro(ArrayList<Produto> listPro) {
        this.listPro = listPro;
    }

    public void addProdList(Produto produtos) {
        listPro.add(produtos);
    }

    public String prodMaisCaro(ArrayList<Produto> listPro) {
        float index = 0;
        String maisCaro = "";
        for (Produto produt : listPro) {
            if (produt.getPreco() > index) {
                index = produt.getPreco();
                maisCaro = "Nome: " + produt.getNome() + " Preço: " + produt.getPreco() + " Data aquisição: " + produt.getDataAquisicao();
            }
        }
        return maisCaro;
    }

    public ArrayList prodDate(ArrayList<Produto> listProds) {
        LocalDate data = LocalDate.parse("2019-11-20");
        ArrayList<Produto> listPartData = new ArrayList();

        for (Produto parti : listProds) {
            if (parti.getDataAquisicao().isBefore(data)) {
                listPartData.add(parti);
            }
        }
        return listPartData;
    }

    public String rturnPesquisa(ArrayList<Produto> listProduts, String nomeProduto) {
        String prodPesquisa = "";
        for (Produto pesquisaProds : listProduts) {
            if (pesquisaProds.getNome().equals(nomeProduto)) {
                prodPesquisa = "Nome: " + pesquisaProds.getNome() + " Preço: " + pesquisaProds.getPreco() + " Data aquisição: " + pesquisaProds.getDataAquisicao();
            }
        }
        return prodPesquisa;
    }

    @Override
    public String toString() {
        return "Loja{" + "nome=" + nome + ", listPro=" + listPro.toString() + '}';
    }

}

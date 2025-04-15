/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame.gui;

import java.util.List;

/**
 *
 * @author Julia
 */
public class Supermercado {

    private List<Produto> listProdutos;

    public Supermercado() {
    }

    public Supermercado(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public Produto pegarNomeProduto(String nome) {
        for (Produto produto : listProdutos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Supermercado{" + "listProdutos=" + listProdutos + '}';
    }

}

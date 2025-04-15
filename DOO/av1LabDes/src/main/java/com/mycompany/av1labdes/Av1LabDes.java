/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.av1labdes;

/**
 *
 * @author Julia
 */
public class Av1LabDes {
    //Exercício 1: letra B)
    //Exercício 2: letra C)

    public static void main(String[] args) {
        Armazem<Produto> armazem = new Armazem<>();

        Produto p = new Produto();
        p.setNome("Notebook");
        p.setPreco(4.600);
        armazem.armazenar(p);
        Produto pObter = armazem.obter();
        ManipuladorReflexivo m = new ManipuladorReflexivo();
        m.exibirMetodos(pObter);
        m.invocarMetodo(pObter, "exibirDescricao");
    }
}

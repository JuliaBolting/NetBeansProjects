/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trab1edd;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.mostra();

        Nodo novoNodo = new Nodo();
        novoNodo.setValor(10);
        lista.insereInicio(novoNodo);

        novoNodo = new Nodo();
        novoNodo.setValor(5);
        lista.insereFim(novoNodo);

        novoNodo = new Nodo();
        novoNodo.setValor(8);
        lista.insereFim(novoNodo);

        novoNodo = new Nodo();
        novoNodo.setValor(74);
        lista.insereFim(novoNodo);

        novoNodo = new Nodo();
        novoNodo.setValor(66);
        lista.insereFim(novoNodo);

        lista.mostra();

        System.out.println("Inserir posição especifica!");
        novoNodo = new Nodo();
        novoNodo.setValor(11);
        lista.inserePosicaoEspecifica(2, novoNodo);

        lista.mostra();

        System.out.println("Inserir posição especifica!");

        novoNodo = new Nodo();
        novoNodo.setValor(48);
        lista.inserePosicaoEspecifica(4, novoNodo);

        lista.mostra();

        System.out.println("Remover posição especifica!");

        lista.removePosicaoEspecifica(5);

        lista.mostra();

    }

}

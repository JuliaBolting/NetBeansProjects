/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nodo;

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
        
        lista.mostra();
        
        int posicao = 1;
        Nodo nodoAcessado = lista.acesso(posicao);
        if (nodoAcessado == null) {
            System.out.println("Não existe na lista!");
        } else 
            System.out.println("Nodo acessado: " + nodoAcessado.getValor());
        
        int valor = 5;
        Nodo nodoPesquisa = lista.pesquisa(valor);
        if (nodoPesquisa == null) {
            System.out.println("Não existe na lista!");
        } else 
            System.out.println("Nodo pesquisa: " + nodoPesquisa.getValor());
        
//        lista.removeFim();
//        lista.mostra();
//        lista.removeInicio();
//        lista.mostra();
    }
    
}

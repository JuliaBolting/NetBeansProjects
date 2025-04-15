/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab1edd;

/**
 *
 * @author Julia
 */
public class ListaEncadeada {

    private Nodo lista;
    private int nElementos;

    public ListaEncadeada() {
        this.lista = null;
        this.nElementos = 0;
    }

    public void insereInicio(Nodo novoNodo) {

        if (this.lista == null) {
            this.lista = novoNodo;
        } else {
            novoNodo.setProx(lista);
            this.lista = novoNodo;
        }
        this.nElementos++;
    }

    public void insereFim(Nodo novoNodo) {

        if (this.lista == null) {
            this.lista = novoNodo;
        } else {
            Nodo aux = this.lista;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNodo);
        }
        this.nElementos++;
    }

    public void inserePosicaoEspecifica(int posicao, Nodo nodoPass) {
        if (posicao == 0) {
            insereInicio(nodoPass);
        } else if (posicao > this.nElementos) {
            insereFim(nodoPass);
        } else {
            int index = 2;
            Nodo aux = this.lista;
            while (posicao > index) {
                aux = aux.getProx();
                index++;
            }
            nodoPass.setProx(aux.getProx());
            aux.setProx(nodoPass);
        }
    }

    public void removePosicaoEspecifica(int posicao) {
        if (posicao == 0) {
            removeInicio();
        } else if (posicao > this.nElementos) {
            removeFim();
        } else {
            Nodo anterior = acharNodoAnterior(posicao - 2);
            Nodo aux = anterior.getProx();
            Nodo proximo = aux.getProx();
            anterior.setProx(proximo);
            aux.setProx(null);
            this.nElementos--;

        }
    }

    public Nodo acharNodoAnterior(int position) {
        Nodo aux = this.lista;
        for (int i = 0; i < position; i++) {
            aux = aux.getProx();
        }
        return aux;
    }

    public void removeInicio() {

        if (this.lista == null) {
            System.out.println("Lista vazia!");
            this.nElementos = 0;
        } else {
            this.lista = this.lista.getProx();
            this.nElementos--;
        }
    }

    public void removeFim() {

        if (this.lista == null) {
            System.out.println("Lista vazia!");
            this.nElementos = 0;
        } else {
            if (this.lista.getProx() == null) {
                this.lista = null;
                this.nElementos = 0;
            } else {
                Nodo aux = this.lista;
                Nodo anterior = this.lista;
                while (aux.getProx() != null) {
                    anterior = aux;
                    aux = aux.getProx();
                }
                anterior.setProx(null);
                this.nElementos--;
            }
        }
    }

    public void mostra() {

        if (this.lista == null) {
            System.out.println("Lista vazia!");
        } else {
            Nodo aux = this.lista;
            while (aux != null) {
                System.out.println("Valor: " + aux.getValor());
                aux = aux.getProx();
            }
        }
        System.out.println("------------------------");

    }

}

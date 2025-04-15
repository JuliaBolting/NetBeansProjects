/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filas;

/**
 *
 * @author Julia
 */

public class Nodo {
    private int valor;
    private Nodo prox;
    
    public Nodo() {
        this.prox = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Nodo{" + "valor=" + valor 
                + ", prox=" + prox + '}';
    }
    
}

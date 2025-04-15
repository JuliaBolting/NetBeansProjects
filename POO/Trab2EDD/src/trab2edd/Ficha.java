/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab2edd;

/**
 *
 * @author Julia
 */
public class Ficha {

    private String cor;
    private int num;
    private Ficha ultimoElemento;
    private Ficha prox;

    public Ficha() {
    }

    public Ficha(String cor, int num, Ficha ultimoElemento, Ficha prox) {
        this.cor = cor;
        this.num = num;
        this.ultimoElemento = ultimoElemento;
        this.prox = prox;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Ficha getUltimoElemento() {
        return ultimoElemento;
    }

    public void setUltimoElemento(Ficha ultimoElemento) {
        this.ultimoElemento = ultimoElemento;
    }

    public Ficha getProx() {
        return prox;
    }

    public void setProx(Ficha prox) {
        this.prox = prox;
    }
}

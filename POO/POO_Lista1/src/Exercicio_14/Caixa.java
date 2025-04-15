/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio_14;

/**
 *
 * @author Julia
 */
public class Caixa {
    private int notas1;
    private int notas5;
    private int notas10;
    
    public Caixa(){}

    public Caixa(int notas1, int notas5, int notas10) {
        this.notas1 = notas1;
        this.notas5 = notas5;
        this.notas10 = notas10;
    }

    public int getNotas1() {
        return notas1;
    }

    public void setNotas1(int notas1) {
        this.notas1 = notas1;
    }

    public int getNotas5() {
        return notas5;
    }

    public void setNotas5(int notas5) {
        this.notas5 = notas5;
    }

    public int getNotas10() {
        return notas10;
    }

    public void setNotas10(int notas10) {
        this.notas10 = notas10;
    }
    
    public void calcNotas(float valorCompra){
        setNotas10((int) (valorCompra / 10));
        setNotas5((int) ((valorCompra % 10) / 5));
        setNotas1((int) (valorCompra % 5));
    }

    @Override
    public String toString() {
        return "Caixa{" + "notas1=" + notas1 + ", notas5=" + notas5 + ", notas10=" + notas10 + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
 */

public class Banco {

    private String nome;
    private int numero;

    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int num) {
        numero = num;
    }

    public void imprimeDados() {
        System.out.println("Banco: " + nome + "\tNumero do banco " + numero);
    }

}

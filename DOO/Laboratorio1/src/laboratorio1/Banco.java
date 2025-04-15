/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */

public class Banco {

    private String nome;
    private int numero;

    /**
     * @param nome
     *            Nome do banco
     * @param numero
     *            Numero do banco
     */
    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }


    /**
     * @return nome do banco
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return numero do banco
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param nome
     *            Nome do banco
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param num
     *            Numero do banco
     */
    public void setNumero(int num) {
        numero = num;
    }

    /**
     * Metodo para impressao de todos os dados da classe Banco
     */
    public void imprimeDados() {
        System.out.println("Banco: " + nome + "\tNumero do banco " + numero);
    }

}

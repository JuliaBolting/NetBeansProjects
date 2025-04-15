/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */
public class Agencia {
    private String numero;
    private int banco;

    public Agencia() {
    }

    public Agencia(String numero, int banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "AGENCIA: " + numero + "    BANCO  : " + banco;
    }
    
}

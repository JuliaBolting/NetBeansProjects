/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */
public class Conta {

    private double saldo;
    private String numero;
    private String titular;
    private int agencia;
    private int banco;

    public Conta() {
    }

    public Conta(double saldo, String numero, String titular, int agencia, int banco) {
        this.saldo = saldo;
        this.numero = numero;
        this.titular = titular;
        this.agencia = agencia;
        this.banco = banco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "AGENCIA: " + agencia + " BANCO : " + banco + "\nNUMERO : " + numero + "\nTITULAR: " + titular + "\nSALDO : R$" + saldo;
    }

}

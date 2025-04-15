/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
 */

public class Conta {

    protected double saldo;
    private String numero;
    private Cliente titular;
    private Agencia agencia;
    private double acumuladorCPMF;    
    private static double taxaCPMF = 0.038;    

    public Conta(double saldoInicial, String num, Cliente tit, Agencia ag) {
        saldo = saldoInicial;
        numero = num;
        titular = tit;
        agencia = ag;
    }

    public Conta(String num, Cliente tit, Agencia ag) {
        this(0, num, tit, ag);
    }

    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                acumularCPMF(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    public void deposito(double valor) {
        System.out.println("Realizando deposito de R$" + valor + " da conta " + numero);
        if (valor >= 0) {
            this.saldo += valor;
        } else
            System.out.println("O valor do deposito deve ser positivo");
    }

    public void imprimeDados() {
        System.out.println("======================================");
        agencia.imprimeDados();
        System.out.println("Numero da conta: " + numero);
        titular.imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("========================================");
    }

    public double getSaldo() {
        return saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public static double getTaxaCPMF() {
        return taxaCPMF;
    }

    
    public static void setTaxaCPMF(double taxaCPMF) {
        Conta.taxaCPMF = taxaCPMF;
    }
    
    protected void acumularCPMF(double valorSaque) {
        acumuladorCPMF += taxaCPMF * valorSaque;
    }

    public double getCPMFAcumulado() {
        return acumuladorCPMF;
    }    
}


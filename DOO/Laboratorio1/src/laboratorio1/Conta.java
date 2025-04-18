/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */

public class Conta implements Tributavel {

    protected double saldo;
    private String numero;
    private Cliente titular;
    private Agencia agencia;
    private double acumuladorCPMF;    
    private static double taxaCPMF = 0.038;    

    /**
     * @param saldoInicial
     *            Saldo Inicial da conta
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     */
    public Conta(double saldoInicial, String num, Cliente tit, Agencia ag){
        saldo = saldoInicial;
        numero = num;
        titular = tit;
        agencia = ag;
    }

    /**
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     */
    public Conta(String num, Cliente tit, Agencia ag){
        saldo = 0;
        numero = num;
        titular = tit;
        agencia = ag;
    }

    /**
     * @return saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return Numero da agencia da conta
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @return numero da conta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return nome do titular da conta
     */
    public Cliente getTitular() {
        return titular;
    }

    /**
     * @param titular
     *            nome do titular da conta
     */
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    /**
     * @param valor
     *            valor a ser sacado da conta
     * @throws laboratorio1.SaldoInsuficienteException
     */
    public void saque(double valor) throws SaldoInsuficienteException{
        System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                acumularCPMF(valor);
            } else
                throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            throw new SaldoInsuficienteException("O valor de saque deve ser positivo");
        }
    }

    /**
     * @param valor
     *            valor a ser depositado da conta
     */
    public void deposito(double valor) {
        System.out.println("Realizando deposito de R$" + valor + " da conta " + numero);
        if (valor >= 0) {
            this.saldo += valor;
        } else
            System.out.println("O valor do deposito deve ser positivo");
    }

    /**
     * Este metodo deve imprimir todos os dados da conta
     */
    public void imprimeDados() {
        System.out.println("\n======================================");
        agencia.imprimeDados();
        System.out.println("Numero da conta: " + numero);
        titular.imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("========================================\n");
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

    public String getDescricaoTributavel() {
        return "Conta Bancaria";
    }

    public String getNomeImposto() {
        return "CPMF";
    }

    public double calcularImpostos() {
        return acumuladorCPMF;
    }    
}


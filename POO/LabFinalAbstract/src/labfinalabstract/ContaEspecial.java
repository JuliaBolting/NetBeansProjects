/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
 */

public final class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
        super(saldoInicial, num, tit, ag);
        setLimite(limite);
    }

    public ContaEspecial(String num, Cliente tit, Agencia ag, double limite) {
        super(num, tit, ag);
        setLimite(limite);
    }

    @Override
    public void imprimeDados() {
        System.out.println("========================================");
        System.out.println("CONTA ESPECIAL");
        System.out.println("Limite de R$ " + getLimite());
        super.imprimeDados();
    }

    @Override
    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + getNumero());
        if (valor > 0) {
            if ((saldo + limite)>= valor) {
                saldo -= valor;
                acumularCPMF(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public void ajustarLimiteEmPorcentagem(int perc){
        double novoLimite;
        if(perc < 0){
            novoLimite = ((this.limite * perc)/100);
            novoLimite = this.limite - novoLimite;
            System.out.println("O novo limite é " + novoLimite);
            this.limite = novoLimite;
        } else {
            novoLimite = ((this.limite * perc)/100);
            novoLimite = this.limite + novoLimite;
            System.out.println("O novo limite é " + novoLimite);
            this.limite = novoLimite;
            
        }
    }
    
    public void alterarLimiteSoPorcentagem(int perc, double saldo){
        this.limite = (saldo * perc)/100;
    }
}


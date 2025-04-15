/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
 */

public class ContaPoupanca extends Conta {

    private String dataAniversario;

    public ContaPoupanca(double saldoInicial, String num, Cliente tit, Agencia ag, String dataAniversario) {
        super(saldoInicial, num, tit, ag);
        this.dataAniversario = dataAniversario;
    }

    public ContaPoupanca(String num, Cliente tit, Agencia ag, String dataAniversario) {
        super(num, tit, ag);
        this.dataAniversario = dataAniversario;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    @Override
    public void imprimeDados() {
        System.out.println("\n ============ CONTA POUPANCA ====================");
        getAgencia().imprimeDados();
        System.out.println("Numero da conta: " + getNumero());
        System.out.println("Data de aniversario: " + dataAniversario);
        getTitular().imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("========================================\n");
    }


}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */

public class ContaEspecial extends Conta {

    private double limite;

    /**
     * @param saldoInicial
     *            Saldo Inicial da conta
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param limite
     *            limite da conta Especial
     */
    public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
        super(saldoInicial, num, tit, ag);
        this.limite = limite;
    }

    /**
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param limite
     *            limite da conta Especial
     */
    public ContaEspecial(String num, Cliente tit, Agencia ag, double limite) {
        super(num, tit, ag);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    /**
     * @param limite
     *            de credito
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void saque(double valor) throws SaldoInsuficienteException{
        System.out.println("Realizando saque de R$ " + valor + " da conta " + getNumero());
        if (valor > 0) {
            if (saldo + limite >= valor) {
                saldo -= valor;
                acumularCPMF(valor);
            } else {
                throw new SaldoInsuficienteException("Saldo e limite insuficientes");
            }
        } else {
            throw new SaldoInsuficienteException("O valor de saque deve ser positivo");
        }
    }

    /**
     * Este metodo deve imprimir todos os dados da conta Especial
     */
    public void imprimeDados() {
        System.out.println("\n===========CONTA ESPECIAL ===========================");
        getAgencia().imprimeDados();
        System.out.println("Numero da conta: " + getNumero());
        getTitular().imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("Limite : R$" + limite);
        System.out.println("TOTAL  : R$" + (saldo + limite));
        System.out.println("========================================\n");
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio7;

/**
 *
 * @author Julia
 */
public class contaEspecial extends contaPoupanca {

    private float limiteCredito;
    private float saldo;

    public contaEspecial(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public contaEspecial() {
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int verifyLimite(float saldoAficar) {
        if (saldoAficar == limiteCredito || limiteCredito > saldoAficar) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public float returnIfLimiteOverride(float returnLimite){
        return returnLimite;
    }

    @Override
    public float setOpcao(int opcao) {
        float saldoAtual;
            saldoAtual = atualizarSaldo(saldo);
        this.setSaldo(saldoAtual);
        return this.getSaldo();
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}

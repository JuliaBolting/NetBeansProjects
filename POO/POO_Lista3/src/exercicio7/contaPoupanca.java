/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio7;

/**
 *
 * @author Julia
 */
public class contaPoupanca extends contaBancaria {

    private float saldo;
    
    public float setOpcao(int opcao){
        if(opcao == 1)
            atualizarSaldo(saldo-10);
        else
            atualizarSaldo(saldo);
        return this.getSaldo();
    }

    @Override
    public float atualizarSaldo(float saldoAtualizar) {
        this.setSaldo(saldoAtualizar);
        return this.getSaldo();
    }

}

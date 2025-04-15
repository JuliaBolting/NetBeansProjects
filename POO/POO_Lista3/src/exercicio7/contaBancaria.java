/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio7;

/**
 *
 * @author Julia
 */
public class contaBancaria {
    private float saldo;

    public contaBancaria(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public contaBancaria() {
    }
    
    public float atualizarSaldo(float saldoAtualizar){
        this.setSaldo(saldoAtualizar);
        return this.getSaldo();
    }
    
}

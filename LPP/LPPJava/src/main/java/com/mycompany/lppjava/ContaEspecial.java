/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lppjava;

/**
 *
 * @author Julia
 */
class ContaEspecial extends Conta {
    private final int limite;

    public ContaEspecial(int numero, String cliente, int limite) {
        super(numero, cliente);
        this.limite = limite;
    }

    private void desconteUsoLimite() {
        saldo -= 10;
    }

    @Override
    public void efetueDeposito(float valor) {
        saldo += valor;
    }

    @Override
    public void efetueSaque(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else if (valor <= saldo + limite) {
            saldo -= valor;
            desconteUsoLimite();
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    
}

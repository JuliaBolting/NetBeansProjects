/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lppjava;

/**
 *
 * @author Julia
 */
class ContaSimples extends Conta {
    public ContaSimples(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public void efetueSaque(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void efetueDeposito(float valor) {
        saldo += valor;
    }
    
}

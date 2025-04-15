/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lppjava;

/**
 *
 * @author Julia
 */
abstract class Conta implements IConta {
    protected int numero;
    protected float saldo;
    protected String cliente;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public String getCliente() {
        return cliente;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }
    
}

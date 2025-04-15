/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lppjava;

/**
 *
 * @author Julia
 */
public interface IConta {
    int getNumero();
    String getCliente();
    float getSaldo();
    void efetueSaque(float valor);
    void efetueDeposito(float valor);
}

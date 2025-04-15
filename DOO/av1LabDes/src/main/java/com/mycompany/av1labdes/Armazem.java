/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.av1labdes;

/**
 *
 * @author Julia
 * @param <T>
 */
public class Armazem<T> {
    private T objeto;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public void armazenar(T objeto) {
        this.objeto = objeto;
    }

    public T obter() {
        return objeto;
    }
}

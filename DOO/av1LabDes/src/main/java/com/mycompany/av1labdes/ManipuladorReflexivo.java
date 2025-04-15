/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.av1labdes;

import java.lang.reflect.Method;

/**
 *
 * @author Julia
 */
public class ManipuladorReflexivo {

    public void exibirMetodos(Object obj) {
        try {
            Class<?> classe = obj.getClass();
            Method[] metodos = classe.getMethods();
            for (Method metodo : metodos) {
                System.out.println("- " + metodo.getName());
            }
        } catch (Exception e) {
            System.out.println("Erro " + e + "ao invocar a classe exibirMetodos");
        }

    }

    public void invocarMetodo(Object obj, String metodoNome) {
        try {
            Method metodo = obj.getClass().getMethod(metodoNome);
            metodo.invoke(obj);
        } catch (Exception e) {
            System.out.println("Erro " + e + "ao invocar o método: " + metodoNome);
        }
    }

}

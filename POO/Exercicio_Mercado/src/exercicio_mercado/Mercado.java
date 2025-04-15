/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_mercado;

import java.util.Arrays;

/**
 *
 * @author Julia
 */
public class Mercado {
    private String[] compras;
    
    public Mercado(){}

    public String[] getCompras() {
        return compras;
    }

    public void setCompras(String[] compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Mercado{" + "compras=" + Arrays.toString(compras) + '}';
    }
    
}

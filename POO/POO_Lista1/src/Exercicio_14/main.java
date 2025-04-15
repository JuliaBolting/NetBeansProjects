/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio_14;

import javax.swing.JOptionPane;

/**
Suponha que um caixa disponha apenas de notas de 1, 5 e 10 reais.
Considerando que alguém está pagando uma compra, escreva um programa orientada
a objetos que mostre o número mínimo total de cada nota que o caixa deve fornecer
como troco. Suponha que o sistema monetário não utilize moedas.
 */
public class main {
    
    public static void main(String[] args) {
        Caixa caixa = new Caixa();
        
        float compra = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da compra?"));
        
        caixa.calcNotas(compra);
        JOptionPane.showMessageDialog(null, caixa.toString());


    }
    
}

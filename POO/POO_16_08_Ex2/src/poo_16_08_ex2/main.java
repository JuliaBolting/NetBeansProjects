/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_16_08_ex2;

import javax.swing.JOptionPane;

/**
Uma pessoa deseja transformar uma temperatura informada em graus Celsius para graus
Fahrenheit e para graus Kelvin. Faça um programa orientado a objetos que realize as transformações. 
* Para exemplificar a sua solução, crie um objeto, informe o valor em graus Celsius e
momostre os valores correspondentes.
Obs.: Para mostrar os dados do objeto graus, use o comando:
JOptionPane.showMessageDialog(null, graus.toString());
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Temperatura temp = new Temperatura();
        
        String celsius = JOptionPane.showInputDialog("Informe os graus em celsius: ");
        temp.setCelsius(Float.parseFloat(celsius));
        
        JOptionPane.showMessageDialog(null, temp.toString());
        
    }
    
}

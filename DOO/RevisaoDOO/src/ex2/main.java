/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {
    
    public static void main(String[] args) {
        Temperatura temp = new Temperatura();
        String valorTxt = JOptionPane.showInputDialog("Informe os graus: ");
        temp.setGrausC(Double.parseDouble(valorTxt));
        
        JOptionPane.showMessageDialog(null, "Celsius: "+temp.getGrausC());
        
        JOptionPane.showMessageDialog(null, "Fahrenheit: "+temp.celsiusToFah());
        
        JOptionPane.showMessageDialog(null, "Kelvin: "+temp.celsiusToKelvin());
        
    }
    
}

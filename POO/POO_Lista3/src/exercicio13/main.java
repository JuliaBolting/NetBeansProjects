/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio13;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {

        int numX = Integer.parseInt(JOptionPane.showInputDialog("Informe um número para a série:"));
        
        System.out.println(returnSerieS(numX));

    }
    
    public static double returnSerieS(int num){
        if(num == 1){
            return 2;
        } else {
            return ((1 + Math.pow(num, 2)) / num) + returnSerieS(num-1);
        }
            
    }
    
}

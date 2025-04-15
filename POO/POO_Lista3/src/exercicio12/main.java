/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio12;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {

        int numX = Integer.parseInt(JOptionPane.showInputDialog("Informe um número inteiro:"));
        
        returnNums(numX);

    }
    
    public static void returnNums(int num){
        if(num == 1){
            System.out.println(num);
        } else {
            System.out.println(num);
            num--;
            returnNums(num);
        }
            
    }

}

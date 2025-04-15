/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encapsulamento;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class TestarRetangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Retangulo novoRet = new Retangulo();
        novoRet.setLado1(10);
        novoRet.setLado2(5);
        
        JOptionPane.showMessageDialog(null, 
                novoRet.calcularArea(novoRet.getLado1(), novoRet.getLado2())
        );
        JOptionPane.showMessageDialog(null, 
                novoRet.calcularPerimetro(novoRet.getLado1(), novoRet.getLado2())
        );
        
        novoRet.setLado2(7);
        
        JOptionPane.showMessageDialog(null, 
                novoRet.calcularArea(novoRet.getLado1(), novoRet.getLado2())
        );
        JOptionPane.showMessageDialog(null, 
                novoRet.calcularPerimetro(novoRet.getLado1(), novoRet.getLado2())
        );
    }
    
}

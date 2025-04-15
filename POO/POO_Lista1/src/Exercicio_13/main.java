/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio_13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
Desenvolva um programa orientado a objetos que calcule e mostre o total de dias
que uma pessoa já viveu. Considere que um mês tem 30 dias.
 */
public class main {
    
    public static void main(String[] args) {
        Dias dias = new Dias();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String dataNasc = JOptionPane.showInputDialog("Informe sua data de nascimento:");
        dias.setDataNascimento(LocalDate.parse(dataNasc, formato));
        
        dias.setDataAtual(LocalDate.now());
        
        dias.setDiasVividos(dias.calcDias(dias.getDataNascimento(), dias.getDataAtual()));
        
        JOptionPane.showMessageDialog(null, dias.toString());
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio11;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {

        int tamVetor = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor de inteiros:"));

        int vetor[] = new int[tamVetor];

        for (int i = 1; i <= vetor.length; i++) {
            vetor[i-1] = Integer.parseInt(JOptionPane.showInputDialog("Informe um número inteiro para a posição " + i));
        }

        returnVetor(vetor, 0);
    }

    public static void returnVetor(int vetor[], int i) {
        if ((i+1) == vetor.length) {
            System.out.println(vetor[vetor.length - 1]);
        } else {
            System.out.println(vetor[i]);
            i++;
            returnVetor(vetor, i);
        }
    }

}

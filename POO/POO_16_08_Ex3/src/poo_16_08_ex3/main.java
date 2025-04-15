package poo_16_08_ex3;

import javax.swing.JOptionPane;

/**
Crie um novo projeto e depois desenvolva um programa orientado a objetos para modelar
dados de um quadrado. A partir do lado, determine a área e o perímetro de um quadrado. Para
exemplificar a sua solução, crie um objeto, informe o valor do lado (que não pode ser zero ou
negativo) e mostre o valor da área e o valor do perímetro.
Obs.: Use o comando:
JOptionPane.showMessageDialog(null, quadrado.toString());
 */
public class main {

    public static void main(String[] args) {
        Quadrado quad = new Quadrado();
        
        String lado = JOptionPane.showInputDialog("Informe a medida de lado do quadrado: ");
        quad.setLado(quad.verifyLado(Float.parseFloat(lado)));
        
        JOptionPane.showMessageDialog(null, quad.toString());
    }
    
}

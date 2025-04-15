package Exercicio_11;

import javax.swing.JOptionPane;

/**
. Crie um programa orientado a objetos que calcule o seu Índice de Massa Corporal
(IMC), a partir dos valores do peso e da altura desta pessoa.
IMC = peso / altura2
Crie instâncias de objetos (Pessoa1, Pessoa2, Pessoa3), calcule e mostre o IMC para
cada uma delas. Após, implemente um método para classificar os objetos conforme a
tabela abaixo:

 */
public class main {
    
    public static void main(String[] args) {
        IMC imc = new IMC();
        int index = 1;
        
        do{
    
    String peso = JOptionPane.showInputDialog("Informe o pesoda pessoa " + index + ":");
    imc.setPeso(Double.parseDouble(peso));
    
    String altura = JOptionPane.showInputDialog("Informe a altura da pessoa " + index + ":");
    imc.setAltura(Double.parseDouble(altura));
    
    imc.setClassificacao(imc.calcClassificacao(imc.getPeso(), imc.getAltura()));
    
    JOptionPane.showMessageDialog(null, imc.toString());
    
    int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar uma nova pessoa?", "Olá", JOptionPane.YES_NO_OPTION);
    
    if(continuar == JOptionPane.YES_OPTION) index++;
    else index = 0;
    
    
        }while(index > 0);
    
    }
}

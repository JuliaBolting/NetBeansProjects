/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio_12;

import javax.swing.JOptionPane;

/**
Dados três valores X, Y e Z, verificar se eles podem ser os comprimentos dos
lados de um triângulo, e se forem, verificar se é um triângulo equilátero, isóscele ou
escaleno. Se eles não formarem um triângulo, obter a situação do triângulo. Na
elaboração do programa, é necessário a revisão de uma propriedade e três definições.
Propriedade – o comprimento de cada lado de um triângulo é menor do que a
soma dos comprimentos dos outros dois lados.
Definição 1 - chama-se de triângulo equilátero o que tem os comprimentos dos
três lados iguais;
Definição 2 - chama-se de triângulo isóscele o triângulo que tem os
comprimentos de dois lados iguais;
Definição 3 - chama-se triângulo escaleno o triângulo que tem os comprimentos
dos três lados diferentes.
 */
public class main {
    
    public static void main(String[] args) {
        Triangulo tri = new Triangulo();
        
        String valorX = JOptionPane.showInputDialog("Informe o valor de X:");
        tri.setValorX(Double.parseDouble(valorX));
        
        String valorY = JOptionPane.showInputDialog("Informe o valor de Y:");
        tri.setValorY(Double.parseDouble(valorY));
        
        String valorZ = JOptionPane.showInputDialog("Informe o valor de Z:");
        tri.setValorZ(Double.parseDouble(valorZ));
        
        if(tri.verifyIfIsntATri(tri.getValorX(), tri.getValorY(), tri.getValorZ()) == true){
        JOptionPane.showMessageDialog(null, "Não é um triângulo!");
        }else {
            tri.setTipoTri(tri.verifyTipoTri(tri.getValorX(), tri.getValorY(), tri.getValorZ()));
        JOptionPane.showMessageDialog(null, tri.toString());
        }

    }
    
}

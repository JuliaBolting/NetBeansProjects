/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

/**
 *
 * @author Julia
 */
public class main {
        public static void main(String[] args) {
        Multifuncional hp3000 = new Multifuncional();
        
        hp3000.imprimaDocumento();
        hp3000.digitalizeDocumento();
        hp3000.copieDocumento();
        
        
        /*
        Que alterações na estrutura do programa devem ser feitas?
        R - Criada uma interface para definir os métodos base, que são implementados 
        nas classes e assim alterado esses métodos na classe Multifuncional 
        (polimorfismo), ao qual o main chama essa classe e recebe os métodos por 
        inicialização de classe. Diferente do C++, ao qual se podia utilizar 
        herança múltipla, no Java pode-se criar uma interface para a iteração de 
        métodos base e alterá-los em classes implementando essa interface.
        */
    }
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filas;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.mostra();
        
        System.out.println("-------------");

        Nodo novoNodo = new Nodo();
        novoNodo.setValor(10);
        fila.insereFim(novoNodo);

        novoNodo = new Nodo();
        novoNodo.setValor(5);
        fila.insereFim(novoNodo);
        
        System.out.println("-------------");
        
        novoNodo = new Nodo();
        novoNodo.setValor(45);
        fila.insereFim(novoNodo);
        
        System.out.println("-------------");

        fila.mostra();
        
        System.out.println("-------------");
        
        fila.removeInicio();
        
        System.out.println("-------------");
        
        fila.mostra();

    }

}

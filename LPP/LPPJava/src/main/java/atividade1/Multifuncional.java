/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

/**
 *
 * @author Julia
 */
class Multifuncional implements IMultifuncional {
    
    @Override
    public void imprimaDocumento() {
        System.out.println("Estou imprimindo um documento.");
    }

    @Override
    public void digitalizeDocumento() {
        System.out.println("Estou digitalizando um documento.");
    }

    public void copieDocumento() {
        System.out.println("Estou copiando um documento");
        System.out.println("*******");
        digitalizeDocumento();
        imprimaDocumento();
        System.out.println("*******");
    }
    
}

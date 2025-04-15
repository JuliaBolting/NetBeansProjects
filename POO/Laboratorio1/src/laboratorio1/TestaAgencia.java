/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */
public class TestaAgencia {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        agencia.setBanco(234);
        agencia.setNumero("1");

        System.out.println("---------------------------------");
        System.out.println(agencia.toString());
        System.out.println("---------------------------------");

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */
public class TestaCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        cliente.setNome("Maria");
        cliente.setCpf("123154");

        System.out.println("---------------------------------");
        System.out.println(cliente.toString());
        System.out.println("---------------------------------");

    }

}

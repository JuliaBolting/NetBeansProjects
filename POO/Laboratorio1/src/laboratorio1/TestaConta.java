/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */
public class TestaConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.setAgencia(1);
        conta.setBanco(234);
        conta.setNumero("01945");
        conta.setTitular("Maria");
        conta.setSaldo(10000);

        System.out.println("---------------------------------");
        System.out.println(conta.toString());
        System.out.println("---------------------------------");

    }

}

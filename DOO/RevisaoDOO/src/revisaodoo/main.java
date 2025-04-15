/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package revisaodoo;

import java.util.Scanner;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno("Nome2", 1.65, 65);

        System.out.println("e)");
        System.out.println("Aluno1 " + aluno1.toString());
        System.out.println("Aluno2 " + aluno2.toString());

        Scanner input = new Scanner(System.in);
        
        System.out.println("f)");
        System.out.println("Digite o nome do aluno 2: ");
        aluno2.setNome(input.nextLine());

        System.out.println("Digite a altura do aluno 2: ");
        aluno2.setAltura(Double.parseDouble(input.nextLine()));

        System.out.println("Digite o peso do aluno 2: ");
        aluno2.setPeso(Double.parseDouble(input.nextLine()));

        System.out.println("Aluno 2: " + aluno2.toString());

        System.out.println("g)");
        System.out.println("Digite o nome do aluno 2: ");
        aluno2.setNome(input.nextLine());

        int index = 1;

        while (index != 0) {
            System.out.println("Digite a altura do aluno 2: ");
            index = aluno2.verifyAltura(Double.parseDouble(input.nextLine()));
        }

        index = 1;
        while (index != 0) {

            System.out.println("Digite o peso do aluno 2: ");
            index = aluno2.verifyPeso(Double.parseDouble(input.nextLine()));
        }

        System.out.println("Aluno 2: " + aluno2.toString());
    }

}

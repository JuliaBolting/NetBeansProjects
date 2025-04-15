/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio4;

/**
 *
 * @author Julia
 */
public class Main {
    //Exercício 1: letra B)
    //Exercício 2: letra C)

    public static void main(String[] args) {
        int a[][] = new int[5][4];
        int b[][] = new int[4][6];
        int i, j;
        int[][] res = new int[a.length][b[0].length];
        Thread[] threads = new Thread[a.length];

        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[0].length; j++) {
                a[i][j] = (int) (Math.random() * 10);
                System.out.print((int) a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (i = 0; i < b.length; i++) {
            for (j = 0; j < b[0].length; j++) {
                b[i][j] = (int) (Math.random() * 10);
                System.out.print((int) b[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        for (i = 0; i < a.length; i++) {
            threads[i] = new Thread(new MultiplicadorMatriz(a, b, res, i));
            threads[i].start();
        }

        for (i = 0; i < a.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Erro ao join da thread " + e);
            }
        }

        System.out.println("Matriz Resultado:");
        for (int[] linha : res) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }

    }

}

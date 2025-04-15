/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

import java.util.Arrays;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ordenacao o = new Ordenacao();
        
        int[] vetor = {7, 3, 9, 1};
        //System.out.println(Arrays.toString(o.quickSort(vetor, 0, 3)));
        //System.out.println("Trocas QuickSort: "+o.getTroca());
        System.out.println(Arrays.toString(o.bubbleSort(vetor, 0, 3)));
        System.out.println("Trocas BubbleSort: "+o.getTroca());
        
        int[] vetor2 = {45, 5, 10, 2, 1};
        o.resetTrocas();
        //System.out.println(Arrays.toString(o.quickSort(vetor2, 0, 4)));
        //System.out.println("Trocas QuickSort: "+o.getTroca());
        System.out.println(Arrays.toString(o.bubbleSort(vetor2, 0, 4)));
        System.out.println("Trocas BubbleSort: "+o.getTroca());
        
        int[] vetor3 = {7, 2, 4, 2};
        o.resetTrocas();
        //System.out.println(Arrays.toString(o.quickSort(vetor3, 0, 3)));
        //System.out.println("Trocas QuickSort: "+o.getTroca());
        System.out.println(Arrays.toString(o.bubbleSort(vetor3, 0, 3)));
        System.out.println("Trocas BubbleSort: "+o.getTroca());
        
        
    }
    
}

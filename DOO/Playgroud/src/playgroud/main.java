/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playgroud;

/**
 *
 * @author Julia
 */
public class main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        int num = 3;
        int div = 0;
        int res = num/div;
        System.out.println(res);
        } catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
}
    
    
}

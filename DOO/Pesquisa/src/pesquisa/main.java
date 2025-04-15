/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pesquisa;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pesquisa pes = new Pesquisa();
        int[] novoVetor = {10, 20, 30, 40, 50, 60};
        
        pes.setVetor(novoVetor);
        System.out.println(pes.sequencial(40));
        System.out.println(pes.getComparacoes());
        
        
        System.out.println(pes.binaria(40));
        System.out.println(pes.getComparacoes());
        
    }
    
}

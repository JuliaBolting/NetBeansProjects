/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trab3edd;

import java.util.Random;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int m = 111;
        
        TabelaHash hash = new TabelaHash(m);
        
        Random gerador = new Random();
        for (int i = 0; i < 1000; i++) {
            int valor = gerador.nextInt(5000) + 1;
            if(!hash.insere(valor))
                i--;
        }
        
        hash.mostra();
        
        int consultar = 4623;
        if (hash.consulta(consultar) != -1) {
            System.out.println("Pagamento " + consultar + " realizado.");
        } else {
            System.out.println("\nNão encontrado número " + consultar + " para consulta.");
        }
        
        int remover = 4623;
        if(hash.remove(remover) != -1){
        System.out.println("Removido número " + remover + "\n");
        }else {
            System.out.println("Não encontrado número informado para remoção.\n");
        }
        
        hash.mostra();
        
        System.out.println("Total de pagamentos realizados: " + hash.totalPagamentos());

    }
    
}

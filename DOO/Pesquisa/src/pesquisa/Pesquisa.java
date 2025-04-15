/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pesquisa;

/**
 *
 * @author Julia
 */
public class Pesquisa {
    private int[] vetor;
    private int comparacoes;

    public Pesquisa(int[] vetor) {
        this.vetor = null;
        this.comparacoes = 0;
    }

    public Pesquisa() {
    }
    
    public int sequencial(int chave){
        int i = 0;
        while((i <= this.vetor.length-1) && (chave != vetor[i])){
            i = i + 1;
            this.comparacoes++;
        }
        if(i > this.vetor.length){
            return -1;
        }else {
            return i;
        }
    }
    
    public int binaria(int chave){
        int i = 0;
        int fim = this.vetor.length-1;
        while(i <= fim){
            int meio = (i + fim)/2;
            if(this.vetor[meio] == chave){
                return meio;
            } else {
                if(chave < this.vetor[meio]){
                    fim = meio-1;
                } else {
                    i = meio+1;
                }
            }
        }
        if(i > fim){
            System.out.println("Posição = -1");
        }
        return i;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }
    
}

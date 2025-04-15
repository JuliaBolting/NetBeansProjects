/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quicksort;

/**
 *
 * @author Julia
 */
public class Ordenacao {
    private long troca;

    public Ordenacao() {
    }

    public Ordenacao(long troca) {
        this.troca = troca;
    }

    public long getTroca() {
        return troca;
    }

    public void setTroca(long troca) {
        this.troca = troca;
    }
    
    public int[] quickSort(int[] vetor, int inicio, int fim){
        int esq = inicio;
        int dir = fim;
        int pivo = (vetor[(esq+dir)/2]);
        while(esq <= dir){
            while(vetor[esq] < pivo){
                esq = esq+1;
            }
            while(vetor[dir] > pivo){
                dir = dir-1;
            }
            if(esq <= dir){
                this.troca = this.troca+1;
                int i = vetor[dir];
                int j = vetor[esq];
                vetor[dir] = j;
                vetor[esq] = i;
                esq = esq+1;
                dir = dir-1;
            }
        }
        if(dir > inicio){
            quickSort(vetor, inicio, dir);
        }
        if(esq < fim){
            quickSort(vetor, esq, fim);
        }
        return vetor;
    }
    
    public int[] bubbleSort(int[] vetor, int inicio, int fim){
        int n = fim-1;
        boolean houverTroca = true;
        while(houverTroca){
            houverTroca = false;
            for(int i=0; i<n-1; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    houverTroca = true;
                    this.troca = this.troca+1;
                }
            }
        }
        return vetor;
    }
    
    public void resetTrocas(){
        this.troca = 0;
    }
    
}

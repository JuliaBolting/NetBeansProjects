/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab3edd;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
class TabelaHash {

    private final int m;
    private final ArrayList<Integer>[] tabela;
    private int pgtosRealizados;

    public TabelaHash(int m) {
        this.m = m;
        this.tabela = new ArrayList[this.m];
        for (int i = 0; i < this.m; i++) {
            this.tabela[i] = new ArrayList<>();
        }
    }

    public int restoDivisaoInteira(int valor) {
        return valor % this.m;
    }

    //Adicionado if de verificação de pagamentos repetidos
    public boolean insere(int valor) {
        int classe = restoDivisaoInteira(valor);
        if (!this.tabela[classe].contains(valor)) {
            this.tabela[classe].add(valor);
            pgtosRealizados++;
            return true;
        } else 
            return false;
    }

    public void mostra() {
        for (int i = 0; i < this.m; i++) {
            System.out.println("Tab[" + i + "]=(" + this.tabela[i].size() + ") " + this.tabela[i].toString());
        }
    }

    public int consulta(int valor) {
        int index = restoDivisaoInteira(valor);
        for (int i = 0; i < this.tabela[index].size(); i++) {
            if (this.tabela[index].get(i) == valor) {
                System.out.println("\nConsulta para identificador: " + index);
                return i;
            }
        }
        return -1;
    }

    public int remove(int valor) {
        int classe = restoDivisaoInteira(valor);
        int index = this.tabela[classe].indexOf(valor);
        if (index != -1) {
            System.out.println("\nPosição de remoção: " + classe);
            this.tabela[classe].remove(index);
            pgtosRealizados--;
        }
        return index;
    }
    
    public int totalPagamentos() {
        return this.pgtosRealizados;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodo;

/**
 *
 * @author Julia
 */
public class ListaEncadeada {
   private Nodo lista;
   private int nElementos;
   
   public ListaEncadeada() {
       this.lista = null;
       this.nElementos = 0;
   }
   
   public void insereInicio(Nodo novoNodo) {
       
       if (this.lista == null)
           this.lista = novoNodo;
       else {
           novoNodo.setProx(lista);
           this.lista = novoNodo;
       }
       this.nElementos++;
   }
   
   public void insereFim(Nodo novoNodo) {
       
       if (this.lista == null)
           this.lista = novoNodo;
       else {
           Nodo aux = this.lista;
           while (aux.getProx() != null) {
               aux = aux.getProx();
           }
           aux.setProx(novoNodo);
       }
       this.nElementos++;
   }
   
   public void inserePosicaoEspecifica(int posicao) {
       // implementar - trabalho
   }
   
   public void removePosicaoEspecifica(int posicao) {
       // implementar - trabalho
   }
   
   public void removeInicio(){
       
       if (this.lista == null) {
           System.out.println("Lista vazia!");
           this.nElementos = 0;
       } else {
           this.lista = this.lista.getProx();
           this.nElementos--;
       }
   }
   
   public void removeFim() {
       
       if (this.lista == null) {
           System.out.println("Lista vazia!");
           this.nElementos = 0;
       } else {
           if (this.lista.getProx() == null) {
                this.lista = null;
                this.nElementos = 0;
           } else {
                Nodo aux = this.lista;
                Nodo anterior = this.lista;
                while (aux.getProx() != null) {
                    anterior = aux;
                    aux = aux.getProx();
                }
                anterior.setProx(null);
                this.nElementos--;
           }
       }
   }
   
   
   
   public Nodo acesso(int posicao) {
       
       Nodo nodoAcessado = null;
       if (this.lista== null) {
           System.out.println("Lista vazia!");
           return nodoAcessado;
       } else {
           Nodo aux = this.lista;
           int i = 1;
           while (aux.getProx() != null && i != posicao) {
               aux = aux.getProx();
               i++;
           }
           if (i == posicao) {
               nodoAcessado = aux;
               return nodoAcessado;
           } else
               return nodoAcessado;
       }
   }
   
   public Nodo pesquisa(int valor) {
       
       Nodo nodoPesquisado = null;
       if (this.lista== null) {
           System.out.println("Lista vazia!");
           return nodoPesquisado;
       } else {
           Nodo aux = this.lista;
           while (aux.getProx() != null && aux.getValor() != valor) {
               aux = aux.getProx();
           }
           if (aux.getValor() == valor) {
               nodoPesquisado = aux;
               return nodoPesquisado;
           } else
               return nodoPesquisado;
       }
   }
   
   public void mostra() {
        
        if (this.lista == null)
           System.out.println("Lista vazia!");
        else {
           Nodo aux = this.lista;
           while (aux != null) {
               System.out.println("Valor: " + aux.getValor());
               aux = aux.getProx();
           }
        }   

   }
   
    public void mostraComNElementos() {
        
        if (this.lista == null)
           System.out.println("Lista vazia!");
        else {
            Nodo aux = this.lista;
            for (int i = 1; i <= this.nElementos; i++) {
                System.out.println("Valor: " + aux.getValor());
                aux = aux.getProx();
            }
        }   

   }
    
    public void push(Nodo novoNodo){
       
       if (this.lista == null)
           this.lista = novoNodo;
       else {
           novoNodo.setProx(lista);
           this.lista = novoNodo;
       }
       this.nElementos++;
    }
    
    public void pop(){
       
       if (this.lista == null) {
           System.out.println("Lista vazia!");
           this.nElementos = 0;
       } else {
           this.lista = this.lista.getProx();
           this.nElementos--;
       }
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filas;

/**
 *
 * @author Julia
 */
public class Fila {
   private Nodo lista;
   private int nElementos;

    public Fila() {
    }

    public Fila(Nodo lista, int nElementos) {
        this.lista = lista;
        this.nElementos = nElementos;
    }

    public Nodo getLista() {
        return lista;
    }

    public void setLista(Nodo lista) {
        this.lista = lista;
    }

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }
   
   public void insereFim(Nodo novoNodo){
       if(this.lista == null){
           this.lista = novoNodo;
       } else {
           Nodo aux = this.lista;
           while (aux.getProx() != null) {
               aux = aux.getProx();
           }
           aux.setProx(novoNodo);
       }
       this.nElementos++;
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trab2edd;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        Ficha novaFicha = new Ficha();

        System.out.println("1)");

        novaFicha.setCor("N");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(4);
        lista.organizarFila(novaFicha);

        lista.mostra();

        System.out.println("\n2)");
        lista.resetLista();

        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        lista.mostra();

        System.out.println("\n3)");
        lista.resetLista();

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(4);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        lista.mostra();

        System.out.println("\n4)");
        lista.resetLista();

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(4);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(5);
        lista.organizarFila(novaFicha);

        lista.mostra();

        System.out.println("\n5)");
        lista.resetLista();

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        lista.mostra();

        //Teste
        System.out.println("\n6) Teste");
        lista.resetLista();

        novaFicha.setCor("U");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(1);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(2);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(4);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("N");
        novaFicha.setNum(3);
        lista.organizarFila(novaFicha);

        novaFicha = new Ficha();
        novaFicha.setCor("U");
        novaFicha.setNum(5);
        lista.organizarFila(novaFicha);

        lista.mostra();

    }

}

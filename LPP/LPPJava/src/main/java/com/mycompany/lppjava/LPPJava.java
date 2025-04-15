/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lppjava;

/**
 *
 * @author Julia
 */
public class LPPJava {

    public static void main(String[] args) {
        IConta[] contas = new IConta[3];

        contas[0] = new ContaSimples(0, "Joao");
        contas[1] = new ContaPoupanca(1, "Jose");
        contas[2] = new ContaEspecial(2, "Maria", 1500);

        for (int i = 0; i < 3; i++) {
            contas[i].efetueDeposito(1000);
            contas[i].efetueSaque(i * 1000);

            System.out.println("Cliente : " + contas[i].getCliente());
            System.out.println("Numero da conta : " + contas[i].getNumero());
            System.out.println("Saldo : " + contas[i].getSaldo());
            System.out.println();
        }
        
        
        /*
        Que alterações na estrutura do programa devem ser feitas?
        R - Foi criada uma interface para definir os métodos base (IConta), 
        que são implementados pelas classes (ContaSimples, ContaPoupanca e 
        ContaEspecial). Além disso, foi criada uma classe abstrata (Conta) 
        para centralizar a lógica entre as contas. Cada classe altera os 
        métodos da interface (polimorfismo) para os comportamentos específicos.
        Diferentemente do C++, onde seria possível utilizar herança múltipla, 
        no Java, utilizamos uma combinação de interfaces e herança simples. 
        */
    }
    
}

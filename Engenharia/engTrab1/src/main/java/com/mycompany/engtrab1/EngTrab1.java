/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.engtrab1;

/**
 *
 * @author Julia
 */
public class EngTrab1 {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        Produto p1 = new Produto("Notebook", 2500.00);
        Produto p2 = new Produto("Mouse", 50.00);

        pedido.inserirProduto(p1);
        pedido.inserirProduto(p2);

        pedido.mostrarResumo();

        // Tentando setar pagamento no crédito com parcela inválida
        System.out.println("\nTentando pagamento em 100x no crédito:");
        pedido.setFormaPagamento(FormaPagamento.CREDITO, 100); // Deve dar erro (parcela < R$20)

        // Setando corretamente com 5 parcelas
        System.out.println("\nPagando em 5x no crédito:");
        if (pedido.setFormaPagamento(FormaPagamento.CREDITO, 5)) {
            pedido.mostrarResumo();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.engtrab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julia
 */
public class Pedido {
    private List<Produto> produtos;
    private FormaPagamento formaPagamento;
    private int parcelas;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no pedido.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public double getValorTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getValor();
        }
        return total;
    }

    public boolean setFormaPagamento(FormaPagamento formaPagamento, int parcelas) {
        if (produtos.isEmpty()) {
            System.out.println("Não é possível registrar forma de pagamento sem produtos.");
            return false;
        }

        if (formaPagamento == FormaPagamento.CREDITO) {
            double valorParcela = getValorTotal() / parcelas;
            if (valorParcela < 20.0) {
                System.out.println("Cada parcela deve ser maior que R$ 20,00. Valor atual: R$ " + valorParcela);
                return false;
            }
            this.parcelas = parcelas;
        } else {
            this.parcelas = 0;
        }

        this.formaPagamento = formaPagamento;
        return true;
    }

    public void mostrarResumo() {
        System.out.println("Resumo do Pedido:");
        listarProdutos();
        System.out.println("Total: R$ " + getValorTotal());
        if (formaPagamento != null) {
            System.out.println("Forma de Pagamento: " + formaPagamento);
            if (formaPagamento == FormaPagamento.CREDITO) {
                System.out.println("Parcelado em " + parcelas + "x de R$ " + String.format("%.2f", getValorTotal() / parcelas));
            }
        } else {
            System.out.println("Forma de pagamento não definida.");
        }
    }

    
}

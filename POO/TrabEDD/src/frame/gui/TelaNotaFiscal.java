/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame.gui;

/**
 *
 * @author Julia
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaNotaFiscal extends JFrame {
    private final List<Produto> produtos;
    private final double totalPagar;
    private Pessoa p;

    public TelaNotaFiscal(List<Produto> produtos, double totalPagar, Pessoa p) {
        super("Nota Fiscal");

        this.produtos = produtos;
        this.totalPagar = totalPagar;
        this.p = p;

        // Configurando o layout
        setLayout(new BorderLayout());

        // Criando a área de texto para exibir a nota fiscal
        JTextArea notaFiscalArea = new JTextArea();
        notaFiscalArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notaFiscalArea);
        add(scrollPane, BorderLayout.CENTER);

        // Construindo a nota fiscal
        StringBuilder notaFiscal = new StringBuilder();
        notaFiscal.append("========== Nota Fiscal ==========\n\n");
        notaFiscal.append("Nome: ").append(p.getNome());
        notaFiscal.append("\nCPF: ").append(p.getCpf());
        notaFiscal.append("\n\nProdutos:\n");
        for (Produto produto : produtos) {
            notaFiscal.append(produto.getNome()).append(" - R$ ").append(produto.getPreco()).append("\n");
        }
        notaFiscal.append("\nTotal a Pagar: R$ ").append(totalPagar).append("\n\n");
        notaFiscal.append("=================================");
        notaFiscalArea.setText(notaFiscal.toString());

        // Configurações da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


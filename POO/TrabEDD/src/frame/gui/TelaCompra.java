/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame.gui;

/**
 *
 * @author Julia
 */
import frame.util.ProdutoException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;

public class TelaCompra extends JFrame {

    private final JList<Produto> pList;
    private final DefaultListModel<Produto> listaProdutos;
    private final JTextArea detalharP;
    private final JButton bNotaFiscal;
    private final JButton pRemover;
    private final JButton bAdicionar;
    private final JButton bAddQuant;
    private final JButton bExcQuant;
    private final JLabel textValor;
    private double totalValor;
    private final JList<String> cLista;
    private final DefaultListModel<String> listaCarrinho;
    private Pessoa pessoa;

    public TelaCompra(
            Supermercado supermercado,
            JList<Produto> productList,
            DefaultListModel<Produto> listModel,
            JTextArea detalhesArea,
            JButton adicionarButton,
            JButton removerButton,
            JButton emitirNotaButton,
            JButton bAddQuant,
            JButton bExcQuant,
            JLabel totalLabel,
            double totalPagar,
            JList<String> carrinhoList,
            DefaultListModel<String> carrinhoModel,
            Pessoa pessoa
    ) {
        this.pList = productList;
        this.listaProdutos = listModel;
        this.detalharP = detalhesArea;
        this.bAdicionar = adicionarButton;
        this.pRemover = removerButton;
        this.bNotaFiscal = emitirNotaButton;
        this.bAddQuant = bAddQuant;
        this.bExcQuant = bExcQuant;
        this.textValor = totalLabel;
        this.totalValor = totalPagar;
        this.cLista = carrinhoList;
        this.listaCarrinho = carrinhoModel;
        this.pessoa = pessoa;
    }

    public TelaCompra(Supermercado supermercado, Pessoa pessoa) {
        super("Tela Compra");

        this.totalValor = 0.0;

        setLayout(new BorderLayout());

        listaProdutos = new DefaultListModel<>();
        pList = new JList<>(listaProdutos);
        JScrollPane scrollPane = new JScrollPane(pList);
        detalharP = new JTextArea(5, 20);
        detalharP.setEditable(false);

        bAdicionar = new JButton("Adicionar ao Carrinho");
        pRemover = new JButton("Remover do Carrinho");
        bNotaFiscal = new JButton("Emitir Nota Fiscal");
        textValor = new JLabel("Total a Pagar: R$ " + totalValor);
        bAddQuant = new JButton("+");
        bExcQuant = new JButton("-");
        bAddQuant.setVisible(false);
        bExcQuant.setVisible(false);

        listaCarrinho = new DefaultListModel<>();
        cLista = new JList<>(listaCarrinho);

        JPanel telaProd = new JPanel(new BorderLayout());
        telaProd.add(new JLabel("Produtos disponíveis: "), BorderLayout.NORTH);
        telaProd.add(scrollPane, BorderLayout.CENTER);
        telaProd.add(new JScrollPane(detalharP), BorderLayout.SOUTH);
        add(telaProd, BorderLayout.WEST);

        JScrollPane scrollCarrinho = new JScrollPane(cLista);
        JPanel telaCarrinho = new JPanel(new BorderLayout());
        telaCarrinho.add(new JLabel("Carrinho de compras: "), BorderLayout.NORTH);
        telaCarrinho.add(scrollCarrinho, BorderLayout.CENTER);
        add(telaCarrinho, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(5, 1));
        botoes.add(bAdicionar);
        botoes.add(pRemover);
        botoes.add(bNotaFiscal);
        botoes.add(bAddQuant);
        botoes.add(bExcQuant);
        add(botoes, BorderLayout.EAST);
        add(textValor, BorderLayout.SOUTH);

        List<Produto> p = supermercado.getListProdutos();
        for (Produto pp : p) {
            listaProdutos.addElement(pp);
        }

        pList.addListSelectionListener((ListSelectionEvent e) -> {
            Produto proSelecionado = pList.getSelectedValue();
            if (proSelecionado != null) {
                detalharP.setText(
                        "Detalhes do Produto:\nNome: " + proSelecionado.getNome()
                        + "\nPreço: R$ " + proSelecionado.getPreco()
                );
            }
        });

        bAdicionar.addActionListener((ActionEvent e) -> {
            try {
                Produto prodSelec = pList.getSelectedValue();
                if (prodSelec != null) {
                    boolean produtoJaNoCarrinho = false;
                    for (int i = 0; i < listaCarrinho.getSize(); i++) {
                        String item = listaCarrinho.getElementAt(i);
                        String[] parts = item.split(" - R\\$ ");
                        String nomeNoCarrinho = parts[0];
                        double precoNoCarrinho = Double.parseDouble(parts[1].substring(0, parts[1].indexOf(" (")));
                        if (nomeNoCarrinho.equals(prodSelec.getNome()) && precoNoCarrinho == prodSelec.getPreco()) {
                            produtoJaNoCarrinho = true;
                            break;
                        }
                    }
                    if (!produtoJaNoCarrinho) {
                        totalValor += prodSelec.getPreco();
                        textValor.setText("Total a Pagar: R$ " + totalValor);
                        listaCarrinho.addElement(prodSelec.getNome() + " - R$ " + prodSelec.getPreco() + " (1)"); // Adicionando o produto ao carrinho com o preço
                        JOptionPane.showMessageDialog(TelaCompra.this, "Produto adicionado ao carrinho com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(TelaCompra.this, "Este produto já está no carrinho.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    throw new ProdutoException("Selecione um produto disponível para adicionar ao carrinho.");
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        pRemover.addActionListener((ActionEvent e) -> {
            try {
                int indexLista = cLista.getSelectedIndex();
                if (indexLista != -1) {
                    String produtoRemovido = listaCarrinho.getElementAt(indexLista);
                    String[] parts = produtoRemovido.split(" - R\\$ ");
                    Produto produto = supermercado.pegarNomeProduto(parts[0]); // Obtendo o nome do produto
                    if (produto != null) {
                        String[] parts2 = parts[1].split(" \\(");
                        double preco = Double.parseDouble(parts2[0]);
                        int quantidade = Integer.parseInt(parts2[1].replace(")", ""));
                        totalValor -= preco * quantidade;
                        textValor.setText("Total a Pagar: R$ " + totalValor);
                        listaCarrinho.remove(indexLista);
                        JOptionPane.showMessageDialog(TelaCompra.this, "Produto removido do carrinho com sucesso!");
                    }
                } else {
                    throw new ProdutoException("Selecione um produto no carrinho para remover do carrinho.");
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        bNotaFiscal.addActionListener((ActionEvent e) -> {
            try {
                if (cLista.getModel().getSize() == 0) {
                    int confirmacao = JOptionPane.showConfirmDialog(TelaCompra.this, "Tem certeza de que deseja fechar o carrinho e emitir a nota fiscal?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        List<Produto> cc = converterPNota();
                        dispose();
                        TelaNotaFiscal tnf = new TelaNotaFiscal(cc, totalValor, pessoa);
                    }
                } else {
                    throw new ProdutoException("Carrinho de compras vazio! Não há nota fiscal.");
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        bAddQuant.addActionListener((ActionEvent e) -> {
            int itemIndex = cLista.getSelectedIndex();
            if (itemIndex != -1) {
                String produtoSelecionado = listaCarrinho.getElementAt(itemIndex);
                String[] parts = produtoSelecionado.split(" - R\\$ ");
                String[] parts2 = parts[1].split(" \\(");
                double preco = Double.parseDouble(parts2[0]);
                int quantidade = Integer.parseInt(parts2[1].replace(")", ""));
                quantidade++;
                totalValor += preco;
                textValor.setText("Total a Pagar: R$ " + totalValor);
                listaCarrinho.setElementAt(parts[0] + " - R$ " + preco + " (" + quantidade + ")", itemIndex);
            }
        });

        bExcQuant.addActionListener((ActionEvent e) -> {
            int selectedIndex = cLista.getSelectedIndex();
            if (selectedIndex != -1) {
                String produtoSelecionado = listaCarrinho.getElementAt(selectedIndex);
                String[] parts = produtoSelecionado.split(" - R\\$ ");
                String[] parts2 = parts[1].split(" \\(");
                double preco = Double.parseDouble(parts2[0]);
                int quantidade = Integer.parseInt(parts2[1].replace(")", ""));
                if (quantidade > 1) {
                    quantidade--;
                    totalValor -= preco;
                    textValor.setText("Total a Pagar: R$ " + totalValor);
                    listaCarrinho.setElementAt(parts[0] + " - R$ " + preco + " (" + quantidade + ")", selectedIndex);
                }
            }
        });

        cLista.addListSelectionListener((ListSelectionEvent e) -> {
            if (!cLista.isSelectionEmpty()) {
                bAddQuant.setVisible(true);
                bExcQuant.setVisible(true);
            } else {
                bAddQuant.setVisible(false);
                bExcQuant.setVisible(false);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
        public List<Produto> converterPNota() {
        List<String> itensCarrinho = new ArrayList<>();
        for (int i = 0; i < listaCarrinho.getSize(); i++) {
            itensCarrinho.add(listaCarrinho.getElementAt(i));
        }
        List<Produto> produtosCarrinho = new ArrayList<>();
        for (String item : itensCarrinho) {
            String[] parts = item.split(" - R\\$ ");
            String nome = parts[0];
            double preco = Double.parseDouble(parts[1].substring(0, parts[1].indexOf(" (")));
            produtosCarrinho.add(new Produto(nome, preco));
        }
        return produtosCarrinho;
    }

}

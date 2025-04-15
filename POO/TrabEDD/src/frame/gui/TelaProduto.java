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

public class TelaProduto extends JFrame {

    private final JButton bCadastrar;
    private final JButton bRemover;
    private final JButton bEditar;
    private final JButton bVoltar;
    private final JTextField nomeProd;
    private final JTextField precoProd;

    private final ArrayList<Produto> prod;
    private final JList<String> listaProdutos;
    private final DefaultListModel<String> mostrarLista;

    public TelaProduto(
            JButton bCadastrar,
            ArrayList<Produto> prod,
            JList<String> listaProdutos,
            DefaultListModel<String> mostrarLista,
            JTextField nomeProd,
            JTextField precoProd,
            JTextField botaoVoltar,
            JButton bRemover,
            JButton bEditar,
            JButton bVoltar
    ) {
        this.prod = prod;
        this.listaProdutos = listaProdutos;
        this.mostrarLista = mostrarLista;
        this.nomeProd = nomeProd;
        this.precoProd = precoProd;
        this.bCadastrar = bCadastrar;
        this.bRemover = bRemover;
        this.bEditar = bEditar;
        this.bVoltar = bVoltar;
    }

    public TelaProduto() {
        super("Produtos: Administrador");
        setLayout(new BorderLayout());

        JPanel pBotoes = new JPanel(new GridLayout(2, 2));

        nomeProd = new JTextField();
        pBotoes.add(new JLabel("Nome do Produto:"));
        pBotoes.add(nomeProd);
        precoProd = new JTextField();
        pBotoes.add(new JLabel("Preço do Produto:"));
        pBotoes.add(precoProd);

        bCadastrar = new JButton("Cadastrar");
        bRemover = new JButton("Remover");
        bEditar = new JButton("Editar");
        bVoltar = new JButton("Voltar ao login");

        prod = new ArrayList<>();
        mostrarLista = new DefaultListModel<>();
        listaProdutos = new JList<>(mostrarLista);

        JScrollPane scrollPagina = new JScrollPane(listaProdutos);
        add(pBotoes, BorderLayout.NORTH);
        add(scrollPagina, BorderLayout.CENTER);
        JPanel botoesPainel = new JPanel(new FlowLayout());
        botoesPainel.add(bCadastrar);
        botoesPainel.add(bRemover);
        botoesPainel.add(bEditar);
        botoesPainel.add(bVoltar);
        add(botoesPainel, BorderLayout.SOUTH);

        bCadastrar.addActionListener((ActionEvent e) -> {
            try {
                String retornoValidacao = validarCadastro(nomeProd.getText(), precoProd.getText());
                if ("".equals(retornoValidacao)) {
                String retornoValidacao2 = validarDuplicatas(nomeProd.getText(), precoProd.getText());
                    if ("".equals(retornoValidacao2)) {
                        String nomeProduto = nomeProd.getText();
                        double preco = Double.parseDouble(precoProd.getText());
                        Produto produto = new Produto(nomeProduto, preco);
                        prod.add(produto);
                        atualizarLista();
                    } else {
                        throw new ProdutoException(retornoValidacao2);
                    }
                } else {
                    throw new ProdutoException(retornoValidacao);
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        bRemover.addActionListener((ActionEvent e) -> {
            try {
                int itemSelecionado = listaProdutos.getSelectedIndex();
                if (itemSelecionado != -1) {
                    prod.remove(itemSelecionado);
                    atualizarLista();
                } else {
                    throw new ProdutoException("Selecione um produto na lista!");
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        bEditar.addActionListener((ActionEvent e) -> {
            try {
                String retornoValidacao = validarCadastro(nomeProd.getText(), precoProd.getText());
                if ("".equals(retornoValidacao)) {
                    int itemSelecionado = listaProdutos.getSelectedIndex();
                    if (itemSelecionado != -1) {
                        String novoNome = nomeProd.getText();
                        double novoPreco = Double.parseDouble(precoProd.getText());
                        Produto pro = prod.get(itemSelecionado);
                        pro.setNome(novoNome);
                        pro.setPreco(novoPreco);
                        atualizarLista();
                    } else {
                        throw new ProdutoException("Selecione um produto na lista!");
                    }
                } else {
                    throw new ProdutoException(retornoValidacao);
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        bVoltar.addActionListener((ActionEvent e) -> {
            Supermercado sup = new Supermercado();
            sup.setListProdutos(prod);
            TelaLogin login = new TelaLogin(sup);
            dispose();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarLista() {
        mostrarLista.clear();
        for (Produto p : prod) {
            mostrarLista.addElement(p.toString());
        }
    }

    private String validarCadastro(String nomeProd, String preco) {
        if (nomeProd.isEmpty()) {
            return "Nome do Produto está vazio!";
        } else if (preco.isEmpty()) {
            return "Preço do produto está vazio!";
        } else if (nomeProd.isEmpty() && preco.isEmpty()) {
            return "Nome e preço do produto estão vazio!";
        } else if (!preco.matches("^\\d+(\\.\\d+)?$")) {
            return "Insira somente números no preço!";
        } else if(preco.contains(",")){
            return "Expressão inválida, use . (ponto) para separar as casas decimais.";
        }
        return "";

    }

    private String validarDuplicatas(String nomeProd, String preco) {
        double pd = Double.parseDouble(preco);
        for (Produto p : prod) {
            if (nomeProd.equals(p.getNome()) && p.getPreco() == pd) {
                return "Esse produto já existe!";

            }
        }
        return "";
    }

}

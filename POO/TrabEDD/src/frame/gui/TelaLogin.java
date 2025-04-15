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

public class TelaLogin extends JFrame {

    private final JTextField nameText;
    private final JTextField cpfText;
    private final JCheckBox checkAdmin;
    private final Supermercado s;

    public TelaLogin(Supermercado s) {
        super("Login");

        this.s = s;
        Pessoa p = new Pessoa();
        setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("  Nome:");
        JLabel cpfLabel = new JLabel("  CPF:");
        nameText = new JTextField(20);
        cpfText = new JTextField(20);
        checkAdmin = new JCheckBox("Sou administrador");
        JButton loginButton = new JButton("Login");

        add(nameLabel);
        add(nameText);
        add(cpfLabel);
        add(cpfText);
        add(new JLabel());
        add(checkAdmin);
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener((ActionEvent e) -> {
            try {
                String nome = nameText.getText();
                String cpf = cpfText.getText();
                boolean isAdmin = checkAdmin.isSelected();
                boolean supIsNull = false;
                if(s.getListProdutos() == null) supIsNull = true;

                if ((supIsNull || s.getListProdutos().isEmpty()) && !isAdmin) {
                    throw new ProdutoException("Não há produtos cadastrados para a compra. Peça ao administrador cadastrar produtos!");
                }
                if ((nome == null || nome.isEmpty()) || (cpf == null || cpf.isEmpty())) {
                    throw new ProdutoException("Por favor, preencha o nome e o CPF.");
                }
                if (isAdmin) {
                    p.setNome(nome);
                    p.setCpf(cpf);
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login bem-sucedido!");
                    TelaProduto telaAdmin = new TelaProduto();
                    telaAdmin.show();
                    dispose();
                } else {
                    p.setNome(nome);
                    p.setCpf(cpf);
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login bem-sucedido!");
                    TelaCompra telaCompra = new TelaCompra(this.s, p);
                    telaCompra.show();
                    dispose();
                }
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.dao;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BaseLoginFrame extends JFrame {

    protected JTextField txtUsuario;
    protected JPasswordField txtSenha;
    protected JButton btnLogar;
    protected JButton btnCadastro;
    protected JLabel lblMensagem;

    protected BaseLoginFrame(String title) {
        setTitle(title);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblTitulo = new JLabel("Login", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBackground(Color.BLACK);
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("Usuário:"), gbc);
        txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        add(txtUsuario, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("Senha:"), gbc);
        txtSenha = new JPasswordField(20);
        gbc.gridx = 1;
        add(txtSenha, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        btnLogar = new JButton("Logar");
        add(btnLogar, gbc);

        gbc.gridx = 1;
        btnCadastro = new JButton("Cadastrar-se");
        add(btnCadastro, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        lblMensagem = new JLabel("");
        lblMensagem.setForeground(Color.RED);
        add(lblMensagem, gbc);

        JLabel lblCadastro = new JLabel("Você ainda não se cadastrou? Cadastre-se aqui!");
        gbc.gridy = 5;
        add(lblCadastro, gbc);
    }

    protected void setLogarAction(ActionListener listener) {
        btnLogar.addActionListener(listener);
    }

    protected void setCadastroAction(ActionListener listener) {
        btnCadastro.addActionListener(listener);
    }
}

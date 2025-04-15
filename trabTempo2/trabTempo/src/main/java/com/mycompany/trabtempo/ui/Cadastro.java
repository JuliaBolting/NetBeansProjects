package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.dao.UsuarioDAO;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import data.SerializationUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JTextField txtEstado;
    private JTextField txtCidade;
    private JLabel lblMensagem;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    public Cadastro() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Tela de Cadastro");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCadastro = new JPanel();
        panelCadastro.setBackground(new Color(173, 216, 230));
        panelCadastro.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblTitulo = new JLabel("Cadastro de Usuário", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(70, 130, 180));
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelCadastro.add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.BLACK);
        panelCadastro.add(lblNome, gbc);
        txtNome = new JTextField(20);
        txtNome.setBackground(Color.WHITE);
        txtNome.setForeground(Color.BLACK);
        txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCadastro.add(txtNome, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setForeground(Color.BLACK);
        panelCadastro.add(lblLogin, gbc);
        txtLogin = new JTextField(20);
        txtLogin.setBackground(Color.WHITE);
        txtLogin.setForeground(Color.BLACK);
        txtLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1;
        panelCadastro.add(txtLogin, gbc);

        JLabel lblObs = new JLabel("Obs.: Seu nome de usuário é único, escolha bem :)");
        lblObs.setForeground(Color.RED);
        lblObs.setFont(new Font("Arial", Font.PLAIN, 12));
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 10, 10, 10);
        panelCadastro.add(lblObs, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.BLACK);
        panelCadastro.add(lblSenha, gbc);
        txtSenha = new JPasswordField(20);
        txtSenha.setBackground(Color.WHITE);
        txtSenha.setForeground(Color.BLACK);
        txtSenha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1;
        panelCadastro.add(txtSenha, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setForeground(Color.BLACK);
        panelCadastro.add(lblEstado, gbc);
        txtEstado = new JTextField(20);
        txtEstado.setBackground(Color.WHITE);
        txtEstado.setForeground(Color.BLACK);
        txtEstado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1;
        panelCadastro.add(txtEstado, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel panelButtons = new JPanel(new GridLayout(1, 2, 10, 0));
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(135, 206, 250));
        btnVoltar.setForeground(Color.BLACK);
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(135, 206, 250));
        btnCadastrar.setForeground(Color.BLACK);
        panelButtons.add(btnVoltar);
        panelButtons.add(btnCadastrar);
        panelCadastro.add(panelButtons, gbc);

        gbc.gridy = 7;
        lblMensagem = new JLabel("");
        lblMensagem.setForeground(Color.RED);
        panelCadastro.add(lblMensagem, gbc);

        add(panelCadastro, BorderLayout.CENTER);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText();
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());
            String estado = txtEstado.getText();

            if (nome.isEmpty() || login.isEmpty() || senha.isEmpty() || estado.isEmpty()) {
                lblMensagem.setText("Por favor, preencha todos os campos obrigatórios.");
                return;
            }

            try {
                String[] resultado = new UsuarioDAO().verificarLogin(login, senha);

                if ("true".equals(resultado[0])) {
                    lblMensagem.setText("Login já cadastrado.");
                } else {
                    UsuarioDTO user = new UsuarioDTO();
                    user.setNome(nome);
                    user.setLogin(login);
                    user.setSenha(senha);
                    user.setEstado(estado);

                    new UsuarioDAO().cadastrar(user);
                    SerializationUtil.saveUser(user, "user_data.ser");

                    new VerificarEstado().setVisible(true);
                    dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                lblMensagem.setText("Erro ao cadastrar usuário.");
            }

        });

        btnVoltar.addActionListener((ActionEvent e) -> {
            new Login().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cadastro().setVisible(true));
    }
}

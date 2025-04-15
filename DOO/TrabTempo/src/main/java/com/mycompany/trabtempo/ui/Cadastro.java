package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.dao.UsuarioDAO;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import data.SerializationUtil; // Certifique-se de ter este pacote
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
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Título
        JLabel lblTitulo = new JLabel("Cadastro de Usuário", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(lblTitulo, gbc);

        // Nome
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("Nome:"), gbc);
        txtNome = new JTextField(20);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNome, gbc);

        // Login
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("Login:"), gbc);
        txtLogin = new JTextField(20);
        gbc.gridx = 1;
        add(txtLogin, gbc);

        // Mensagem de Observação
        JLabel lblObs = new JLabel("Obs.: Seu nome de usuário é único, escolha bem :)");
        lblObs.setForeground(Color.RED);
        lblObs.setFont(new Font("Arial", Font.PLAIN, 12)); // Tamanho menor
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 10, 10, 10); // Ajusta o espaçamento
        add(lblObs, gbc);

        // Senha
        gbc.insets = new Insets(10, 10, 10, 10); // Restabelece o espaçamento
        gbc.gridy = 4;
        gbc.gridx = 0;
        add(new JLabel("Senha:"), gbc);
        txtSenha = new JPasswordField(20);
        gbc.gridx = 1;
        add(txtSenha, gbc);

        // Estado
        gbc.gridy = 5;
        gbc.gridx = 0;
        add(new JLabel("Estado:"), gbc);
        txtEstado = new JTextField(20);
        gbc.gridx = 1;
        add(txtEstado, gbc);

        // Cidade
        gbc.gridy = 6;
        gbc.gridx = 0;
        add(new JLabel("Cidade:"), gbc);
        txtCidade = new JTextField(20);
        gbc.gridx = 1;
        add(txtCidade, gbc);

        // Painel para os botões
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Ocupa o espaço disponível
        JPanel panelButtons = new JPanel(new GridLayout(1, 2, 10, 0)); // 1 linha, 2 colunas
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");
        panelButtons.add(btnCadastrar);
        panelButtons.add(btnVoltar);
        add(panelButtons, gbc);

        // Mensagem de erro
        gbc.gridy = 8;
        lblMensagem = new JLabel("");
        lblMensagem.setForeground(Color.RED);
        add(lblMensagem, gbc);

        btnCadastrar.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText();
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());
            String estado = txtEstado.getText();
            String cidade = txtCidade.getText();

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
                    user.setCidade(cidade);

                    new UsuarioDAO().cadastrar(user);
                    
                    // Salvar o novo usuário
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
            new Login().setVisible(true); // Abre a tela de login
            dispose(); // Fecha a tela de cadastro
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cadastro().setVisible(true));
    }
}
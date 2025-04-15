package com.mycompany.trabtempo.ui;

import com.mycompany.trabtempo.dao.UsuarioDAO;
import com.mycompany.trabtempo.dao.BaseLoginFrame;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import data.SerializationUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Login extends BaseLoginFrame {

    private UsuarioDTO userDto;

    public Login() {
        super("Tela de Login");

        userDto = SerializationUtil.loadUser("user_data.ser");

        if (userDto != null) {
            txtUsuario.setText(userDto.getLogin());
        }

        setLayout(new BorderLayout());
        String pathImage = "src/main/java/util/imgLogin.jpeg";
        JLabel background = new JLabel(new ImageIcon(pathImage));
        add(background);
        background.setLayout(new GridBagLayout());

        JPanel panelLogin = new JPanel();
        panelLogin.setOpaque(false);
        panelLogin.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblTitle = new JLabel("Login", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelLogin.add(lblTitle, gbc);

        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setBackground(new Color(0, 0, 0, 150));
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setBackground(new Color(0, 0, 0, 150));
        btnLogar.setBackground(new Color(0, 0, 255, 150));
        btnLogar.setForeground(Color.WHITE);
        btnCadastro.setBackground(new Color(0, 0, 255, 150));
        btnCadastro.setForeground(Color.WHITE);
        lblMensagem.setForeground(Color.RED);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.BLACK);
        panelLogin.add(lblUsuario, gbc);

        gbc.gridx = 1;
        panelLogin.add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.BLACK);
        panelLogin.add(lblSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelLogin.add(txtSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelLogin.add(lblMensagem, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelLogin.add(btnLogar, gbc);

        gbc.gridx = 1;
        panelLogin.add(btnCadastro, gbc);

        background.add(panelLogin);

        btnLogar.addActionListener((ActionEvent e) -> handleLogin());
        setCadastroAction((ActionEvent e) -> {
            new Cadastro().setVisible(true);
            dispose();
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (userDto != null) {
                    SerializationUtil.saveUser(userDto, "user_data.ser");
                }
                System.exit(0);
            }
        });
    }

    private void handleLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            lblMensagem.setText("Por favor, preencha todos os campos.");
            return;
        }

        txtUsuario.setEnabled(false);
        txtSenha.setEnabled(false);
        btnLogar.setEnabled(false);
        btnCadastro.setEnabled(false);
        lblMensagem.setText("");

        SwingUtilities.invokeLater(() -> {
            try {
                String[] results = verificarUsuario(usuario, senha);
                String res = results[0];
                if ("true".equals(res)) {
                    UsuarioDTO usuarioDTO = new UsuarioDAO().setUser(usuario);
                    userDto = usuarioDTO;
                    SerializationUtil.saveUser(userDto, "user_data.ser");
                    new VerificarEstado().setVisible(true);
                    dispose();
                } else {
                    lblMensagem.setText(results[1]);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                lblMensagem.setText("Erro ao verificar usuário.");
            } finally {
                txtUsuario.setEnabled(true);
                txtSenha.setEnabled(true);
                btnLogar.setEnabled(true);
                btnCadastro.setEnabled(true);
            }
        });
    }

    private String[] verificarUsuario(String login, String senha) throws SQLException {
        String[] resultado = new UsuarioDAO().verificarLogin(login, senha);
        String[] loginValido = new String[2];
        boolean um = "true".equals(resultado[0]);
        loginValido[0] = "" + um;
        loginValido[1] = resultado[1];
        return loginValido;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}

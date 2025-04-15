package com.mycompany.trabtempo.ui;

import com.mycompany.trabtempo.dao.UsuarioDAO;
import com.mycompany.trabtempo.dao.BaseLoginFrame;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import data.SerializationUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Login extends BaseLoginFrame {

    private UsuarioDTO userDto;

    public Login() {
        super("Tela de Login");

        // Carregar o estado do usuário ao iniciar
        userDto = SerializationUtil.loadUser("user_data.ser");

        if (userDto != null) {
            txtUsuario.setText(userDto.getLogin());
        }

        // Configura os listeners para os botões
        btnLogar.addActionListener((ActionEvent e) -> handleLogin());
        setCadastroAction((ActionEvent e) -> {
            new Cadastro().setVisible(true);
            dispose();
        });

        // Configurar um listener para salvar ao fechar a janela
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
        String usuario = txtUsuario.getText();  // Corrigir: inicializar a partir do JTextField
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            lblMensagem.setText("Por favor, preencha todos os campos.");
            return;
        }

        // Desabilitar componentes
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
                    // Atualizar o estado do usuário para persistir
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
                // Reabilitar componentes
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

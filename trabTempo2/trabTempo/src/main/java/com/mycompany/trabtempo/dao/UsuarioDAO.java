/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.dao;

import com.mycompany.trabtempo.Conexao;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Julia
 */
public class UsuarioDAO {

    public void cadastrar(UsuarioDTO user) {

        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, ESTADO, CIDADE, UF) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConecxao().prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getEstado());
            ps.setString(5, user.getCidade());
            ps.setString(6, user.getUf());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] verificarLogin(String login, String senha) {
        String sql = "SELECT SENHA FROM USUARIO WHERE LOGIN = ?";
        String[] result = new String[2];

        try (Connection con = Conexao.getConecxao(); PreparedStatement pss = con.prepareStatement(sql)) {

            pss.setString(1, login);

            try (ResultSet rs = pss.executeQuery()) {
                if (rs.next()) {
                    String senhaArmazenada = rs.getString("SENHA");
                    if (senhaArmazenada.equals(senha)) {
                        result[0] = "true";
                        result[1] = "Login bem-sucedido!";
                    } else {
                        result[0] = "false";
                        result[1] = "Senha incorreta!";
                    }
                } else {
                    result[0] = "false";
                    result[1] = "Usuário não encontrado!";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result[0] = "false";
            result[1] = "Erro ao acessar o banco de dados!";
        }

        return result;
    }

    public UsuarioDTO setUser(String login) {
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ?";
        UsuarioDTO setarUser = new UsuarioDTO();

        try (Connection con = Conexao.getConecxao(); // Obtenha a conexão
                 PreparedStatement pss = con.prepareStatement(sql)) {
            pss.setString(1, login);
            try (ResultSet rs = pss.executeQuery()) {
                if (rs.next()) {
                    setarUser.setNome(rs.getString("NOME"));
                    setarUser.setLogin(rs.getString("LOGIN"));
                    setarUser.setSenha(rs.getString("SENHA"));
                    setarUser.setEstado(rs.getString("ESTADO"));
                    setarUser.setCidade(rs.getString("CIDADE"));
                    setarUser.setUf(rs.getString("UF"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setarUser;
    }

}

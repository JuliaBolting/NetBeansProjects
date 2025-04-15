package com.mycompany.trabtempo.dao;

import com.mycompany.trabtempo.Conexao;
import com.mycompany.trabtempo.entity.CidadeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {

    public List<CidadeDTO> getCatastrofes() {
        List<CidadeDTO> catastrofes = new ArrayList<>();
        String query = "SELECT idCatastrofe, ano, titulo, descricao FROM clientes.lages";

        try (Connection conn = Conexao.getConecxao(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idCatastrofe");
                String ano = rs.getString("ano");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                CidadeDTO catastrofe = new CidadeDTO(id, ano, titulo, descricao);
                catastrofes.add(catastrofe);
            }
            System.out.println(catastrofes.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catastrofes;
    }
}

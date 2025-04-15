/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Julia
 */
public class Conexao {

    private static final String urlBanco = "jdbc:mysql://localhost:3306/clientes";
    private static final String user = "root";
    private static final String password = "mlt2007";

    public static Connection getConecxao() throws SQLException {
        return DriverManager.getConnection(urlBanco, user, password);
    }
}


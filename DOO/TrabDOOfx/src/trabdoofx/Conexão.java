/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabdoofx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Julia
 */
public class Conexão {
    
    private static final String urlBanco = "jdbc:mysql://localhost:3306/clientes";
    private static final String user = "root";
    private static final String password = "mlt2007";
    
    private static Connection conn;
    
    public static Connection getConecxao() {
        try {
            if(conn == null){
                conn = DriverManager.getConnection(urlBanco, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}

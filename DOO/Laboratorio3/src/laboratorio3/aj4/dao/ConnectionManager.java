package laboratorio3.aj4.dao;

import java.sql.*;
import laboratorio3.util.CodeException;

public class ConnectionManager {

    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String DATABASE = "clientes";
    private static final String IP = "127.0.0.1";
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    public static Connection getConexao() throws CodeException {
        Connection conn = null;
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new CodeException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new CodeException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            String errorMsg = "Nao foi possivel fechar a conexao com o banco";
            CodeException.print(e, errorMsg);
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            String errorMsg = "Nao foi possivel fechar a conexao com o banco";
            CodeException.print(e, errorMsg);
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            String errorMsg = "Nao foi possivel fechar a conexao com o banco";
            CodeException.print(e, errorMsg);
        }
    }
    
}

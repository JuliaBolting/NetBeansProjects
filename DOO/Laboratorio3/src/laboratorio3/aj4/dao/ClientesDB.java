package laboratorio3.aj4.dao;

import beans.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import laboratorio3.util.CodeException;

public class ClientesDB implements ClientesDAO {

    private final static String SALVAR_CLIENTE = "INSERT INTO clientes (nome,cpf,telefone) VALUES (?,?,?)";
    private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  clientes (id int(3) NOT NULL AUTO_INCREMENT   PRIMARY KEY, nome VARCHAR(20) NOT NULL, cpf varchar(20) NOT NULL, telefone varchar(20) NOT NULL)";
    private final static String DELETE_CLIENTE = "DELETE FROM clientes WHERE cpf = '";
    private final static String GET_ALL_CLIENTES = "SELECT * FROM clientes";
    private final static String GET_CLIENTE_BY_CPF = "SELECT * FROM clientes WHERE cpf = ?";

    public void createTable() throws CodeException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionManager.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CodeException("Erro ao criar a tabela de clientes : " + CREATE_TABLE, e);
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
    }

    public void excluir(String cpf) throws CodeException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionManager.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate(DELETE_CLIENTE + cpf + "'");
        } catch (SQLException e) {
            String errorMsg = "Nao foi possivel fechar o statement com o banco de Dados!";
            e.printStackTrace();
            throw new CodeException(errorMsg, e);
        }
    }

    public void salvar(Cliente cliente) throws CodeException {
        if (!cliente.equals(getClienteByCPF(cliente.getCpf()))) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                conn = ConnectionManager.getConexao();
                stmt = conn.prepareStatement(SALVAR_CLIENTE);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getTelefone());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.closeAll(conn, stmt);
            }
        }
    }

    public List getAllClientes() throws CodeException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List clientes = new ArrayList();
        try {
            conn = ConnectionManager.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(GET_ALL_CLIENTES);
            while (rs.next()) {
                Cliente cli = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("cpf"), rs.getInt("id"));
                clientes.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, stmt, rs);
        }
        return clientes;
    }

    public Cliente getClienteByCPF(String cpf) throws CodeException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cli = null;
        conn = ConnectionManager.getConexao();
        try {
            stmt = conn.prepareStatement(GET_CLIENTE_BY_CPF);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cli = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("cpf"), rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, stmt, rs);
        }
        return cli;
    }
}

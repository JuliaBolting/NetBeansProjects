package laboratorio3.aj4.dao;

import beans.Cliente;
import java.util.List;
import laboratorio3.util.CodeException;


public interface ClientesDAO {
    
    public abstract void salvar(Cliente cliente) throws CodeException;

    public abstract void excluir(String cpf) throws CodeException;

    public abstract List getAllClientes() throws CodeException;

    public abstract Cliente getClienteByCPF(String cpf) throws CodeException;
}
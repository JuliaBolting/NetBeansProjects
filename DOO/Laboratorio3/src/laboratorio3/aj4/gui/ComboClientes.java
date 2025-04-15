
package laboratorio3.aj4.gui;

import java.util.*;
import javax.swing.JComboBox;

import laboratorio3.aj4.dao.ClientesDAO;
import laboratorio3.aj4.dao.ClientesDB;
import laboratorio3.util.CodeException;


public class ComboClientes extends JComboBox {

    public ComboClientes() throws CodeException {
        this.reloadFromDatabase();
    }

    public void reloadFromDatabase() throws CodeException {
        ClientesDAO db = new ClientesDB();
        List clientes = db.getAllClientes();
        this.removeAllItems();
        for (int i = 0; i < clientes.size(); i++) {
            this.addItem(clientes.get(i));
        }
    }
}

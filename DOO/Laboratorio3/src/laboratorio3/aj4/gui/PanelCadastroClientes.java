
package laboratorio3.aj4.gui;

import beans.Cliente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import laboratorio3.aj4.dao.ClientesDAO;
import laboratorio3.aj4.dao.ClientesDB;
import laboratorio3.util.CodeException;

public class PanelCadastroClientes extends JPanel {

    private JLabel lNome;
    private JTextField tfNome;
    private JLabel lTelefone;
    private JTextField tfTelefone;
    private JLabel lCPF;
    private JTextField tfCPF;
    private JLabel lID;
    private JTextField tfID;
    private JPanel pCadastroCliente;
    private JPanel pBotoesCadastro;
    private JButton bExcluir;
    private JButton bSalvar;
    private JButton bNovo;
    private ComboClientes comboClientes;

    public PanelCadastroClientes() throws CodeException {
        this.setLayout(new BorderLayout());
        pCadastroCliente = montaPanelCadastroCliente();
        pBotoesCadastro = montaPanelBotoesCadastro();
        comboClientes = new ComboClientes();
        this.add(pCadastroCliente, BorderLayout.CENTER);
        this.add(pBotoesCadastro, BorderLayout.SOUTH);
        this.add(comboClientes, BorderLayout.NORTH);
        this.add(pCadastroCliente, BorderLayout.CENTER);
        this.add(pBotoesCadastro, BorderLayout.SOUTH);
        comboClientes.addActionListener(new CarregarClienteHandler());
    }

    private JPanel montaPanelBotoesCadastro() {
        JPanel pBotoesCadastro = new JPanel();
        bSalvar = new JButton("Salvar");
        bSalvar.setMnemonic(KeyEvent.VK_S);
        bSalvar.addMouseListener(new SalvarClienteHandler());
        bNovo = new JButton("Novo");
        bNovo.setMnemonic(KeyEvent.VK_N);
        bNovo.addMouseListener(new NovoClienteHandler());
        bExcluir = new JButton("Excluir");
        bExcluir.setMnemonic(KeyEvent.VK_E);
        pBotoesCadastro.add(bSalvar);
        pBotoesCadastro.add(bExcluir);
        pBotoesCadastro.add(bNovo);
        return pBotoesCadastro;
    }

    private JPanel montaPanelCadastroCliente() {
        JPanel pCadastroCliente = new JPanel();
        GridLayout layout = new GridLayout(8, 1);
        pCadastroCliente.setLayout(layout);
        lNome = new JLabel("Nome:");
        tfNome = new JTextField();
        lTelefone = new JLabel("Telefone:");
        tfTelefone = new JTextField();
        lCPF = new JLabel("CPF:");
        tfCPF = new JTextField();
        lID = new JLabel("ID:");
        tfID = new JTextField();
        tfID.setEditable(false);
        pCadastroCliente.add(lNome);
        pCadastroCliente.add(tfNome);
        pCadastroCliente.add(lTelefone);
        pCadastroCliente.add(tfTelefone);
        pCadastroCliente.add(lCPF);
        pCadastroCliente.add(tfCPF);
        pCadastroCliente.add(lID);
        pCadastroCliente.add(tfID);
        return pCadastroCliente;
    }

    private void clearClienteFromPanel() {
        System.out.println("Limpando o painel de cadastro de clientes");
        this.tfCPF.setText("");
        this.tfNome.setText("");
        this.tfTelefone.setText("");
        this.tfID.setText("");
    }
    
    private Cliente loadClienteFromPanel() throws CodeException {
        System.out.println("Carregando o cliente em edi�ao para um objeto da classe Cliente");
        String nome = tfNome.getText();
        String cpf = tfCPF.getText();
        String telefone = tfTelefone.getText();
        String strId = tfID.getText();
        int id = 0;
        if ((strId != null) && (strId.length() > 0)) {
            id = Integer.parseInt(strId);
        }
        Cliente clienteAtual = new Cliente(nome, cpf, telefone, id);
        return clienteAtual;
    }

    private void loadClienteToPanel(Cliente c) {
        if (c != null) {
            System.out.println("Carregando cliente selecionado para edi�ao");
            this.tfCPF.setText(c.getCpf());
            this.tfID.setText(Integer.toString(c.getId()));
            this.tfNome.setText(c.getNome());
            this.tfTelefone.setText(c.getTelefone());
        }
    }
    
    class SalvarClienteHandler extends MouseAdapter {

        Cliente cliente = null;

        public void mouseClicked(MouseEvent arg0) {
            Cliente cliente = null;
            try {
                cliente = loadClienteFromPanel();
                ClientesDAO dao = new ClientesDB();
                dao.salvar(cliente);
                comboClientes.reloadFromDatabase();
            } catch (CodeException e) {
                e.printStackTrace();
            }
            System.out.println(cliente);
        }
    }

    class NovoClienteHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            clearClienteFromPanel();
        }
    }

    class CarregarClienteHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            loadClienteToPanel(cliente);
        }
    }

}
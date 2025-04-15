/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame.gui;

/**
 *
 * @author Julia
 */
import beans.Cliente;
import frame.util.CodeException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanelCadastroClientes extends JPanel implements ActionListener{

    private JLabel lNome;
    private JTextField tfNome;
    private JLabel lTelefone;
    private JTextField tfTelefone;
    private JLabel lID;
    private JTextField tfID;
    private JLabel lCPF;
    private JTextField tfCPF;
    private JPanel pCadastroCliente;
    private JPanel pBotoesCadastro;
    private JButton bExcluir;
    private JButton bSalvar;
    private JButton bNovo;

    /**
     * Este construtor monta um Panel para insercao de dados de Cadastro de Clientes,
     * @throws frame.util.CodeException
     */
    public PanelCadastroClientes() throws CodeException {
        this.setLayout(new BorderLayout());
        // Montagem do panel para insercao ou edicao de um cliente
        pCadastroCliente = montaPanelCadastroCliente();
        // Montagem do panel com botoes para salvar ou excluir clientes
        pBotoesCadastro = montaPanelBotoesCadastro();
        /**************************************************************************
         * Adicao dos paineis pCadastroCliente e pBotoesCadastro no panel principal
         *************************************************************************/
        this.add(pCadastroCliente, BorderLayout.CENTER);
        this.add(pBotoesCadastro, BorderLayout.SOUTH);
    }

    /**
     * Metodo utilizado internamente para montagem do JPanel com o botao Salvar, por isto ele foi declarado como
     * private.
     * 
     * @return JPanel com o botao Salvar, para salvar um cliente
     */
    private JPanel montaPanelBotoesCadastro() {
        JPanel pBotoesCadastro = new JPanel();
        this.bSalvar = new JButton("Salvar");
        this.bNovo = new JButton("Novo");
        this.bExcluir = new JButton("Excluir");
        
        this.bSalvar.addActionListener(this);
        this.bNovo.addActionListener(this);
        this.bExcluir.addActionListener(this);
        
        pBotoesCadastro.add(this.bSalvar);
        pBotoesCadastro.add(this.bNovo);
        pBotoesCadastro.add(this.bExcluir);
        // 1) Implemente aqui o painel de botoes como imagem mostrada em sua apostila,
        // Dica: Para associar uma tecla ao botao utilize o metodo setMnemonic(),
        // usando como parametro os atributos KeyEvent.VK_(Letra)
        return pBotoesCadastro;
    }

    /**
     * Metodo utilizado internamente para montagem do JPanel para cadastro ou edicao de um cliente, por isto ele foi
     * declarado como private.
     * 
     * @return JPanel para cadastro ou edicao de um cliente
     * 
     */
    private JPanel montaPanelCadastroCliente() {
        JPanel pCadastroCliente = new JPanel();
        this.lNome = new JLabel("Nome: ");
        pCadastroCliente.add(lNome);
        setSize(275,100);
        this.tfNome = new JTextField(10);
        pCadastroCliente.add(tfNome);
        this.lTelefone = new JLabel("Telefone: ");
        pCadastroCliente.add(lTelefone);
        setSize(275,100);
        this.tfTelefone = new JTextField(10);
        pCadastroCliente.add(tfTelefone);
        this.lID = new JLabel("ID: ");
        pCadastroCliente.add(lID);
        setSize(275,100);
        this.tfID = new JTextField(10);
        pCadastroCliente.add(tfID);
        this.lCPF = new JLabel("CPF: ");
        pCadastroCliente.add(lCPF);
        setSize(275,100);
        this.tfCPF = new JTextField(10);
        pCadastroCliente.add(tfCPF);
        return pCadastroCliente;
    }
    @Override
        public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.bSalvar) {
            salvar();
        } else if (evento.getSource() == this.bNovo) {
            novo();
        } else if (evento.getSource() == this.bExcluir) {
            excluir();
        }
    }

    private void novo() {
        this.tfNome.setText("");
        this.tfTelefone.setText("");
        this.tfCPF.setText("");
        this.tfID.setText("");
    }

    private void salvar() {
        int id = Integer.parseInt(tfID.getText());
        String nome = this.tfNome.getText();
        String telefone = this.tfTelefone.getText();
        String cpf = this.tfCPF.getText();

        Cliente cliente = new Cliente(nome, telefone, cpf, id);
        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
    }

    private void excluir() {
        
        JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
    }
}

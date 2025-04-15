import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

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

    /**
     * Este construtor monta um Panel para insercao de dados de Cadastro de Clientes,
     * @throws CodeException
     */
    public PanelCadastroClientes() throws CodeException {
        this.setLayout(new BorderLayout());
        // Montagem do panel para insercao ou edicao de um cliente
        pCadastroCliente = montaPanelCadastroCliente();
        // Montagem do panel com botoes para salvar ou excluir clientes
        pBotoesCadastro = montaPanelBotoesCadastro();
        /***************************************************************************************************************
         * Adicao dos paineis pCadastroCliente e pBotoesCadastro no panel principal
         **************************************************************************************************************/
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
        // Implementar o Listener para o botao Salvar
        JPanel pBotoesCadastro = new JPanel();
        EventosMouse even = new EventosMouse();
        bSalvar = new JButton("Salvar");
        bSalvar.setMnemonic(KeyEvent.VK_S);
        bSalvar.addMouseListener(even);
        bNovo = new JButton("Novo");
        bNovo.setMnemonic(KeyEvent.VK_N);
        bNovo.addMouseListener(even);
        bExcluir = new JButton("Excluir");
        bExcluir.setMnemonic(KeyEvent.VK_E);
        bExcluir.addMouseListener(even);
        pBotoesCadastro.add(bSalvar);
        pBotoesCadastro.add(bExcluir);
        pBotoesCadastro.add(bNovo);
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
}
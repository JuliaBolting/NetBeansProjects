/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package frame.gui;

/**
 *
 * @author Julia
 */
import frame.util.CodeException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestePanelCadastroClientes extends JFrame {

    public TestePanelCadastroClientes(String titulo) {
        super(titulo);
        // Indica que quando a janela for fechada, a execucao da classe
        // sera finalizada, caso contrario, a classe continuara na memoria
        // depois que a janela for fechada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.getContentPane().add(new PanelCadastroClientes());
            super.setSize(300, 200);
            this.show();
        } catch (CodeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Mensagem de Erro", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestePanelCadastroClientes gf = new TestePanelCadastroClientes("Teste Panel Cadastro Clientes");
        gf.show();
    }
}

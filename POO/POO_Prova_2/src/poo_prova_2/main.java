/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_prova_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loja loja = new Loja();
        Produto produto = new Produto();

        float totalPreco = 0;

        String nomeLoja = JOptionPane.showInputDialog("Informe o nome da loja:");
        loja.setNome(nomeLoja);

        int index = 0;

        do {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String nomePro = JOptionPane.showInputDialog("Informe o nome do produto da loja " + nomeLoja + ":");
            produto.setNome(nomePro);

            String preco = JOptionPane.showInputDialog("Informe o preço do produto " + nomePro + " da loja " + nomeLoja + ":");
            int precoF = Integer.parseInt(preco);
            produto.setPreco(precoF);

            String data = JOptionPane.showInputDialog("Informe a data de aquisição do produto " + nomePro + " da loja " + nomeLoja + ":");
            LocalDate dataLD = LocalDate.parse(data, formato);
            produto.setDataAquisicao(dataLD);

            totalPreco = totalPreco + precoF;

            loja.addProdList(new Produto(nomePro, precoF, dataLD));

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de adicionar mais produtos?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                index++;
            } else {
                index = 0;
            }

        } while (index != 0);

        JOptionPane.showMessageDialog(null, loja.toString());
        JOptionPane.showMessageDialog(null, "Soma dos preços: " + totalPreco);
        JOptionPane.showMessageDialog(null, "Produto mais caro: " + loja.prodMaisCaro(loja.getListPro()));
        JOptionPane.showMessageDialog(null, "Produto comprados antes de 20/11/2019: " + loja.prodDate(loja.getListPro()));

        int indexPesquisa = 0;

        do {
            String pesquisaNomeProd = JOptionPane.showInputDialog("Informe o nome do produto para a pesquisa:");
            JOptionPane.showMessageDialog(null, "Aluno da pesquisa: " + loja.rturnPesquisa(loja.getListPro(), pesquisaNomeProd));

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de pesquisar mais produtos?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);
    }

}

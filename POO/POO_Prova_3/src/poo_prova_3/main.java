/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_prova_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        Veiculo veiculo = new Veiculo();
        Terrestre terr = new Terrestre();
        Aquatico aqua = new Aquatico();
        Pessoa pessoa = new Pessoa();
        Auxiliar aux = new Auxiliar();
        DataD auxData = new DataD();
        ArrayList<String> listDataTerr = new ArrayList();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String tipoVeic;

        String veic;
        int indexPesquisa = 0;

        do {
            int continuar = JOptionPane.showConfirmDialog(null, "O veículo é terrestre?", "Olá", JOptionPane.YES_NO_OPTION);
            if (continuar == JOptionPane.YES_OPTION) {
                tipoVeic = "0";
                veic = JOptionPane.showInputDialog("Informe o modelo do veículo terrestre:");
                terr.setModelo(veic);
                pessoa.addTerrList(new Terrestre(veic));
            } else {
                tipoVeic = "1";
                veic = JOptionPane.showInputDialog("Informe a altura da proa do veículo aquático:");
                aqua.setAlturaProa(Float.parseFloat(veic));
            }
            String dataFab = JOptionPane.showInputDialog("Insira a data de fabricação do veículo:");
            LocalDate dataLD = LocalDate.parse(dataFab, formato);
            veiculo.setDataFabricacao(dataLD);
            String[] convertData = dataFab.split("/");
            String convertido = (convertData[2]+ "-" + convertData[1] + "-" + convertData[0]);
            auxData.addDataList(new Auxiliar(tipoVeic, veic, convertido));

            int cadastrar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais veículos?", "Olá", JOptionPane.YES_NO_OPTION);

            if (cadastrar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

        for (Auxiliar vetorString : auxData.getListDta()) {
            String listData = veiculo.prodDate(vetorString);
            if (listData != "0") {
                listDataTerr.add(listData);
                //auxData.setListDtaAux(ve);
            }
        }
        JOptionPane.showMessageDialog(null, "Lista dos modelos terrestres com data maior que 01/01/2000: " + listDataTerr.toString());
        JOptionPane.showMessageDialog(null, "Calculo do dia^mes: " + veiculo.calcDiaMes(0));

        Polimorfismo p = new Polimorfismo();
        p.doPolimorfism(new Veiculo());
        p.doPolimorfism(new Terrestre());
        p.doPolimorfism(new Aquatico());

    }

}

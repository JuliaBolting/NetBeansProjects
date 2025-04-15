/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio6;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        Estado estado = new Estado();
        Cidade cidade = new Cidade();
        
        ArrayList<Cidade> listCidade = new ArrayList<>();

        float totalArea = 0;
        int qtdadeArea = 0;
        int maiorPop = 0;

            String nomeEstado = JOptionPane.showInputDialog("Informe o estado:");
            estado.setNome(nomeEstado);

            String siglaEstado = JOptionPane.showInputDialog("Informe a sigla do estado " + nomeEstado + ":");
            estado.setSigla(siglaEstado);

            int qtdadeCid = Integer.parseInt(JOptionPane.showInputDialog("Quantas cidades gostaria de cadastrar no estado " + nomeEstado + "?"));

            do {

                String nomeCidade = JOptionPane.showInputDialog("Informe o nome da cidade do estado " + nomeEstado + ":");
                cidade.setNome(nomeCidade);

                String popCidade = JOptionPane.showInputDialog("Informe a população da cidade " + nomeCidade + " do estado " + nomeEstado + ":");
                int popCidadeF = Integer.parseInt(popCidade);
                cidade.setPopulacao(popCidadeF);

                String climaCidade = JOptionPane.showInputDialog("Informe o clima da cidade " + nomeCidade + " do estado " + nomeEstado + ":");
                cidade.setClima(climaCidade);

                String areaCidade = JOptionPane.showInputDialog("Informe a area da cidade " + nomeCidade + " do estado " + nomeEstado + ":");
                float areaCidadeF = Float.parseFloat(areaCidade);
                cidade.setArea(areaCidadeF);

                totalArea = totalArea + areaCidadeF;
                qtdadeArea = qtdadeArea + 1;
                //listCidade.add(cidade);
                //estado.setListaCidades(listCidade);
                estado.getListaCidades().add(cidade);

                if (popCidadeF > maiorPop) {
                    maiorPop = popCidadeF;
                }

                qtdadeCid--;

            } while (qtdadeCid != 0);            

        float media = totalArea / qtdadeArea;
        JOptionPane.showMessageDialog(null, "Media das áreas: " + media);
        JOptionPane.showMessageDialog(null, estado.returnMaiorPop(maiorPop));
        JOptionPane.showMessageDialog(null, estado.toString());

        int indexPesquisa = 0;
        do {

            String nomeClimaPesquisa = JOptionPane.showInputDialog("Informe o clima da cidade que gostaria de pesquisar:");
            JOptionPane.showMessageDialog(null, "Quantidade de clima "+ nomeClimaPesquisa+ " : " +estado.returnQuantClima(nomeClimaPesquisa));

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de pesquisar mais climas?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {

        ArrayList<Participante> listPart = new ArrayList<>();
        ArrayList<Participante> listPartData = new ArrayList<>();
        ArrayList<Palestrante> listPales = new ArrayList<>();
        ArrayList<Palestrante> listPalesMasculino = new ArrayList<>();
        Participante part = new Participante();
        Palestrante pale = new Palestrante();

        int indexPesquisa = 0;

        do {

            String nomeParticipante = JOptionPane.showInputDialog("Informe o nome do participante:");
            part.setNome(nomeParticipante);

            String dataParticipante = JOptionPane.showInputDialog("Informe a data do participante: (formato AAAA-MM-dd");
            part.setDatanasc(LocalDate.parse(dataParticipante));

            listPart.add(part);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais participantes?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

        int index = 0;
        do {

            String nomePalestrante = JOptionPane.showInputDialog("Informe o nome do palestrante:");
            pale.setNome(nomePalestrante);

            String sexoPalestrante = JOptionPane.showInputDialog("Informe a sexo do palestrante: (M maiúsculo e sem abreviações)");
            pale.setSexo(sexoPalestrante);

            listPales.add(pale);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais palestrante?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                index++;
            } else {
                index = 0;
            }

        } while (index != 0);

        JOptionPane.showMessageDialog(null, "Participantes: " + listPart.size());
        JOptionPane.showMessageDialog(null, "Palestrantes: " + listPales.size());

        LocalDate data = LocalDate.parse("2020-10-03");

        for (Participante parti : listPart) {
            if (parti.getDatanasc().isBefore(data)) {
                listPartData.add(parti);
            }
        }

        for (Palestrante palest : listPales) {
            if ("Masculino".equals(palest.getSexo())) {
                listPalesMasculino.add(palest);
            }
        }

        JOptionPane.showMessageDialog(null, "Participantes com data maior que: " + listPartData.toString());
        JOptionPane.showMessageDialog(null, "Palestrantes masculinos: " + listPalesMasculino.toString());

    }

}

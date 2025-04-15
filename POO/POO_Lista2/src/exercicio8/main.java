/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio8;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {

        ArrayList<Alunos> listPart = new ArrayList<>();
        ArrayList<String> listAluno = new ArrayList<>();
        ArrayList<Professores> listPales = new ArrayList<>();
        ArrayList<String> listProfessores = new ArrayList<>();
        Alunos part = new Alunos();
        Professores pale = new Professores();

        int indexPesquisa = 0;

        do {

            String nomeAlunos = JOptionPane.showInputDialog("Informe o nome do Alunos:");
            part.setNome(nomeAlunos);

            String moradiaAlunos = JOptionPane.showInputDialog("Informe a localização/cidade do Alunos:");
            part.setMoradia(moradiaAlunos);

            listPart.add(part);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais Alunos?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

        int index = 0;
        do {

            String nomeProfessores = JOptionPane.showInputDialog("Informe o nome do Professores:");
            pale.setNome(nomeProfessores);

            String titulacaoProfessores = JOptionPane.showInputDialog("Informe a titulação do Professores:");
            pale.setTitulacao(titulacaoProfessores);

            listPales.add(pale);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais Professores?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                index++;
            } else {
                index = 0;
            }

        } while (index != 0);

        JOptionPane.showMessageDialog(null, "Alunos: " + listPart.size());
        JOptionPane.showMessageDialog(null, "Professores: " + listPales.size());


        for (Alunos parti : listPart) {
            if (!"Lages".equals(parti.getMoradia())) {
                listAluno.add(parti.getNome());
            }
        }

        for (Professores palest : listPales) {
            if (palest.getTitulacao().equals("Doutorado")) {
                listProfessores.add(palest.getNome());
            }
        }

        JOptionPane.showMessageDialog(null, "Alunos fora de Lages: " + listAluno.toString());
        JOptionPane.showMessageDialog(null, "Professores com doutorado: " + listProfessores.toString());

    }
    
}

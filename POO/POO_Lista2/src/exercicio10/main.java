/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio10;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        Curso curso = new Curso();
        Turma turma = new Turma();
        Aluno aluno = new Aluno();

        int indexPesquisa = 0;

        do {

            String nomeTurma = JOptionPane.showInputDialog("Informe o nome da turma:");
            turma.setNome(nomeTurma);

            int depends = JOptionPane.showConfirmDialog(null, "A turma tem alunos?", "Olá", JOptionPane.YES_NO_OPTION);

            if (depends == JOptionPane.YES_OPTION) {

                int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de alunos da turma:"));

                do {

                    String nomeAluno = JOptionPane.showInputDialog("Informe o nome do aluno:");
                    aluno.setNome(nomeAluno);

                    String sexoAluno = JOptionPane.showInputDialog("Informe o sexo do aluno:");
                    aluno.setSexo(sexoAluno);

                    String matriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno:");
                    aluno.setMatricula(matriculaAluno);

                    turma.getListAluno().add(aluno);
                    numero--;

                } while (numero != 0);

            }

            curso.getListTurma().add(turma);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais turmas?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

        int maiorAlunos = 0;
        String turmaMaiorString = "";

        for (Turma turmaMaior : curso.getListTurma()) {
            if (turmaMaior.getListAluno().size() > maiorAlunos) {
                turmaMaiorString = turmaMaior.getNome();
            }
        }
        JOptionPane.showMessageDialog(null, "Turma com maior alunos: " + turmaMaiorString);

        String pesquisaNomeTurma = JOptionPane.showInputDialog("Informe o nome da turma para a Pesquisa:");
        String pesquisaMatriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno para a Pesquisa:");
        String alunoEncontrado = "";

        for (Turma pesquisaTurma : curso.getListTurma()) {
            if (pesquisaTurma.getNome().equals(pesquisaNomeTurma)) {
                for (Aluno pesquisaAluno : pesquisaTurma.getListAluno()) {
                    if (pesquisaAluno.getMatricula().equals(pesquisaMatriculaAluno)) {
                        alunoEncontrado = "Aluno: " + pesquisaAluno.getNome() + " Matricula: " + pesquisaAluno.getMatricula() + "Sexo: " + pesquisaAluno.getSexo();
                    }
                }

            }
        }
        JOptionPane.showMessageDialog(null, "Aluno da pesquisa: " + alunoEncontrado);

        ArrayList<String> listAluno = new ArrayList<>();

        for (Turma pesquisaTurmaAlunos : curso.getListTurma()) {
            if (pesquisaTurmaAlunos.getNome().equals("Programação")) {
                for (Aluno pesquisaAlunos : pesquisaTurmaAlunos.getListAluno()) {
                    if (pesquisaAlunos.getSexo().equals("Feminino")) {
                        listAluno.add(pesquisaAlunos.getNome());
                    }
                }

            }
        }
        JOptionPane.showMessageDialog(null, "Alunas de Programação: " + listAluno.toString());

    }

}

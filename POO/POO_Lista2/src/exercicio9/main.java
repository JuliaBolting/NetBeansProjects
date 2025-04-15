/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio9;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Funcionario func = new Funcionario();
        Dependente depen = new Dependente();

        ArrayList<String> listFunFem = new ArrayList<>();

        String nomeEmpresa = JOptionPane.showInputDialog("Informe o nome da empresa:");
        empresa.setNome(nomeEmpresa);

        int indexPesquisa = 0;
        int numFuncionarios = 0;
        float salario = 0;

        do {

            String nomeFuncionario = JOptionPane.showInputDialog("Informe o nome do funcionario:");
            func.setNome(nomeFuncionario);

            String sexoFun = JOptionPane.showInputDialog("Informe o sexo do funcionário:");
            func.setSexo(sexoFun);

            String salarioFun = JOptionPane.showInputDialog("Informe o salario do funcionário:");
            float salarioF = Float.parseFloat(salarioFun);
            func.setSalario(salarioF);
            salario = salario + salarioF;
            numFuncionarios = numFuncionarios + 1;

            int depends = JOptionPane.showConfirmDialog(null, "O funcionário tem dependentes?", "Olá", JOptionPane.YES_NO_OPTION);

            if (depends == JOptionPane.YES_OPTION) {

                int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de dependentes do funcionário:"));
                
                do{

                String nomeDepen = JOptionPane.showInputDialog("Informe o nome do dependente:");
                depen.setNome(nomeDepen);

                String sexoDepen = JOptionPane.showInputDialog("Informe o sexo do dependente:");
                depen.setSexo(sexoDepen);

                func.getListDepen().add(depen);
                numero--;
                
                }while(numero != 0);

            }

            empresa.getListaFun().add(func);

            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais funcionários?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                indexPesquisa++;
            } else {
                indexPesquisa = 0;
            }

        } while (indexPesquisa != 0);

        for (Funcionario funcionar : empresa.getListaFun()) {
            if ("Feminino".equals(funcionar.getSexo())) {
                listFunFem.add(funcionar.getNome());
            }
        }
        JOptionPane.showMessageDialog(null, "Funcionários femininos: " + listFunFem.toString());

        String nomeFunDepend = JOptionPane.showInputDialog("Informe o nome do funcionário que gostaria de verificar os dependentes:");
        int numDepends = 0;
        for (Funcionario funcionar : empresa.getListaFun()) {
            if (nomeFunDepend.equals(funcionar.getNome())) {
                numDepends = funcionar.getListDepen().size();
            }
        }
        JOptionPane.showMessageDialog(null, "Num dependentes do funcionário " + nomeFunDepend + ": " + numDepends);

        float media = salario / numFuncionarios;
        JOptionPane.showMessageDialog(null, "Média dos salários: " + media);

    }

}

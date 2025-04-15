/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio7;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        contaBancaria bancaria = new contaBancaria();
        contaEspecial especial = new contaEspecial();

        float saldoInicial = Float.parseFloat(JOptionPane.showInputDialog("Informe o saldo inicial:"));
        bancaria.setSaldo(saldoInicial);

        float limite = Float.parseFloat(JOptionPane.showInputDialog("Informe o limite de crédito:"));
        especial.setLimiteCredito(limite);

        int index = 0;
        do {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n1 - Saque \n2 - Depósito"));

            float atualizar;
            if (opcao == 1) {
                atualizar = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor de saque:"));
                atualizar = -(atualizar + 10);
            } else {
                atualizar = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor de deposito:"));
            }
            float saldoAficar = bancaria.getSaldo() + atualizar;
            if (especial.verifyLimite(saldoAficar) != 1) {
                especial.setSaldo(saldoAficar);
                JOptionPane.showMessageDialog(null, especial.setOpcao(opcao));
                bancaria.setSaldo(saldoAficar);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível fazer a transação pois ela irá atingir o limite de crédito. \nSaldo: " + bancaria.getSaldo() + "\nLimite: " + especial.getLimiteCredito());
            }
            int continuar = JOptionPane.showConfirmDialog(null, "Gostaria de fazer mais transações?", "Olá", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.YES_OPTION) {
                index++;
            } else {
                index = 0;
            }
        } while (index != 0);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio_mercado;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        ArrayList<String[]> compras = new ArrayList<>();

        int parar;
        int j = 0;
        do {
            String[] vetor = new String[3];
            String nomeCompra = JOptionPane.showInputDialog("Informe o produto: ");
            String preco = JOptionPane.showInputDialog("Informe o preço do produto: ");
            String codigo = JOptionPane.showInputDialog("Informe o código do produto: ");

            vetor[0] = nomeCompra;
            vetor[1] = preco;
            vetor[2] = codigo;
            mercado.setCompras(vetor);
            compras.add(j, mercado.getCompras());
            System.out.println(Arrays.toString(compras.get(j)));
            j++;
            mercado.setCompras(null);

            parar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais produtos?", "Olá", JOptionPane.YES_NO_OPTION);

        } while (parar == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Produtos cadastrados: \n" + Arrays.deepToString(compras.toArray()));

        ArrayList<String[]> listaMaior = new ArrayList<>();
        int k = 0;
        int l = 0;

        for (int i = 1; i <= compras.size(); i++) {
            float valor = Float.parseFloat(compras.get(k)[1]);
            if (valor > 100) {
                listaMaior.add(compras.get(k));
                System.out.println(Arrays.toString(listaMaior.get(l)));
                l++;
            }
            k++;
        }

        JOptionPane.showMessageDialog(null, "Produtos com preço maior que 100: \n" + Arrays.deepToString(listaMaior.toArray()));

        int m = 0;
        boolean haveCod111 = false;
        for (int i = 1; i <= compras.size(); i++) {
            int cod = Integer.parseInt(compras.get(m)[2]);
            if (cod == 111) {
                JOptionPane.showMessageDialog(null, "Produto com código 111: \n" + Arrays.toString(compras.get(m)));
                haveCod111 = true;
            }
            m++;
        }
        if(haveCod111 == false){
            JOptionPane.showMessageDialog(null, "Não há produtos com código 111");
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_prova_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class main {

    public static void main(String[] args) {
        Compra compra = new Compra();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String nomeCliente = JOptionPane.showInputDialog("Informe o nome do/a comprador/a: ");
        compra.setCliente(nomeCliente);
        
        String valorCompra = JOptionPane.showInputDialog("Informe o valor da compra: ");
        compra.setValorTotalAPagar(Double.parseDouble(valorCompra));
        
        String dataCompra = JOptionPane.showInputDialog("Informe a data da compra: ");
        LocalDate dataCompras = LocalDate.parse(dataCompra, formato);
        LocalDate dataFormater = LocalDate.of(dataCompras.getYear(), dataCompras.getMonthValue(), dataCompras.getDayOfMonth());
        compra.setDataCompra(dataCompras);
        
        LocalDate dataComparar = LocalDate.of(2022, 10,1); 
        
        if(compra.verifyDate(dataFormater, dataComparar)){
            JOptionPane.showMessageDialog(null, "Data da compra é superior a 01/10/2022");
        }
        
        int continuar = JOptionPane.showConfirmDialog(null, "A forma de pagamento será à vista?", "Olá", JOptionPane.YES_NO_OPTION);
        
        if(continuar == JOptionPane.YES_OPTION) compra.setaVista(true);
        else compra.setaVista(false);
        
        if(compra.isaVista()){
            int descontoInt = 0;
            do{
            String descontoPercentual = JOptionPane.showInputDialog("Informe o valor de desconto à vista entre 1% e 10%: ");
            descontoInt = Integer.parseInt(descontoPercentual);
            }while(descontoInt < 1 || descontoInt > 10);
            compra.setDesconto(descontoInt);
            compra.calcValorVista(Double.parseDouble(valorCompra), descontoInt);
        }else {
            compra.calcValorPrazo(Double.parseDouble(valorCompra));
        }
        
        JOptionPane.showMessageDialog(null, compra.toString());
        
    }
    
}

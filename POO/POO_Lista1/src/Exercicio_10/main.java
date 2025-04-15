package Exercicio_10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
Considere que para um automóvel que realizou determinado percurso, se tenha:
marca, quilometragem inicial, quilometragem final, litros consumidos, data de
fabricação e capacidade do tanque de combustível. Faça um programa orientada a
objetos que calcule o consumo médio do automóvel em Km/litros e calcule a sua
autonomia, considerando que o motorista encheu o tanque antes do percurso.
 */
public class main {
    
    public static void main(String[] args) {
        Automovel auto = new Automovel();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String nome = JOptionPane.showInputDialog("Informe a marca do automóvel:");
        auto.setMarca(nome);
        
        String kmInicial = JOptionPane.showInputDialog("Informe a quilometragem inicial do automóvel:");
        auto.setKmInicial(Float.parseFloat(kmInicial));
        
        String kmFinal = JOptionPane.showInputDialog("Informe a quilometragem final do automóvel:");
        auto.setKmFinal(Float.parseFloat(kmFinal));
        
        String litrosConsum = JOptionPane.showInputDialog("Informe a litros consumidos do automóvel:");
        auto.setLitrosConsum(Double.parseDouble(litrosConsum));
        
        String dataFabricacao = JOptionPane.showInputDialog("Informe a data de fabricação do automóvel:");
        auto.setDataFabricacao(LocalDate.parse(dataFabricacao, formato));
        
        String capTanqueCombus = JOptionPane.showInputDialog("Informe a capacidade do tanque de combustível do automóvel:");
        auto.setCapCombustivel(Double.parseDouble(capTanqueCombus));
        
        //auto.calcKmRodado(kmInicial, kmFinal);
        JOptionPane.showMessageDialog(null, auto.toString());
        
    }
    
}

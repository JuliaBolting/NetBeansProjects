/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Julia
 */
public class Veiculo {

    private LocalDate dataFabricacao;

    public Veiculo() {
    }

    public Veiculo(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public void polimorfismo() {
        System.out.println("Polimorfismo Veiculo");
    }

    public String prodDate(Auxiliar listVeic) {
        LocalDate data = LocalDate.parse("2000-01-01");
        String retorno = "0";
        if (listVeic.getTipo() == "0") {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataObtida = LocalDate.parse(listVeic.getData(), formato);
            if (dataObtida.isBefore(data)) {
                return listVeic.getDadoVec();
            }
        }

        return retorno;
    }

    public double calcDiaMes(int i) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = this.getDataFabricacao().format(formato);
        String[] vecDta = data.split("/");
        if (i == 0) {
            return (Math.pow(Double.parseDouble(vecDta[i]), calcDiaMes(i + 1)));
        } else {
            return Double.parseDouble(vecDta[i]);
        }
    }

}

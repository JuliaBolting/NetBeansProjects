/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio_13;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Julia
 */
public class Dias {
    private LocalDate dataNascimento;
    private LocalDate dataAtual;
    private int diasVividos;
    
    public Dias(){}

    public Dias(LocalDate dataNascimento, LocalDate dataAtual, int diasVividos) {
        this.dataNascimento = dataNascimento;
        this.dataAtual = dataAtual;
        this.diasVividos = diasVividos;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public int getDiasVividos() {
        return diasVividos;
    }

    public void setDiasVividos(int diasVividos) {
        this.diasVividos = diasVividos;
    }
    
    public int calcDias(LocalDate dataNascimento, LocalDate dataAtual){
        Period periodo = Period.between(dataNascimento, dataAtual);
        int soma;
        soma = (periodo.getMonths() * 30);
        soma = soma + (periodo.getYears() * 365);
        soma = soma + periodo.getDays();
        return (int) soma;

    }

    @Override
    public String toString() {
        return "Dias{" + "dataNascimento=" + dataNascimento + ", dataAtual=" + dataAtual + ", diasVividos=" + diasVividos + '}';
    }
    
}

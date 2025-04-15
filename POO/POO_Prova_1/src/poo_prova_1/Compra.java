/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Julia
 */
public class Compra {
    private String cliente;
    private LocalDate dataCompra;
    private double valorTotalAPagar;
    private int desconto;
    private boolean aVista;
    private double valorAVista;
    private double valorAPrazo;
    
    public Compra(){}

    public Compra(String cliente, LocalDate dataCompra, double valorTotalAPagar, int desconto, boolean aVista) {
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.valorTotalAPagar = valorTotalAPagar;
        this.desconto = desconto;
        this.aVista = aVista;
    }
    
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Compra(double valorAVista, double valorAPrazo) {
        this.valorAVista = valorAVista;
        this.valorAPrazo = valorAPrazo;
    }

    public double getValorAVista() {
        return valorAVista;
    }

    public void setValorAVista(double valorAVista) {
        this.valorAVista = valorAVista;
    }

    public double getValorAPrazo() {
        return valorAPrazo;
    }

    public void setValorAPrazo(double valorAPrazo) {
        this.valorAPrazo = valorAPrazo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    public void setValorTotalAPagar(double valorTotalAPagar) {
        this.valorTotalAPagar = valorTotalAPagar;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public boolean isaVista() {
        return aVista;
    }

    public void setaVista(boolean aVista) {
        this.aVista = aVista;
    }
    
    public boolean verifyDate(LocalDate dataCompra, LocalDate dataComparar){
        return dataCompra.isAfter(dataComparar);
    }
    
    public void calcValorVista(double valorCompra, double valorDesconto){
        this.setValorAVista(valorCompra - ((valorCompra * valorDesconto)/ 100));
    }
    
    private double calcJuros(double valorCompra){
        return (valorCompra * 15)/ 100;
    }
    
    public void calcValorPrazo(double valorCompra){
        this.setValorAPrazo(valorCompra + calcJuros(valorCompra));
    }
    
    public String returnValorFinal(boolean vista){
        if(vista){
            return String.valueOf(this.getValorAVista());
        } else {
            return String.valueOf(this.getValorAPrazo());
        }
    }

    @Override
    public String toString() {
        return "Compra" + "cliente=" + cliente + ", dataCompra=" + dataCompra.format(formatador) + ", valorTotalAPagar=" + valorTotalAPagar + ", desconto=" + desconto + ", aVista=" + aVista + ", valorFinalAPagar=" + returnValorFinal(aVista) +'}';
    }
    
    
    
}

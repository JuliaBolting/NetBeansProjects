/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_3;

import java.time.LocalDate;

/**
 *
 * @author Julia
 */
public class Terrestre extends Veiculo{
    private String modelo;

    public Terrestre() {
    }

    public Terrestre(String modelo) {
        this.modelo = modelo;
    }

    public Terrestre(String modelo, LocalDate dataFabricacao) {
        super(dataFabricacao);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void polimorfismo(){
        System.out.println("Polimorfismo Terrestre");
    }
    
}

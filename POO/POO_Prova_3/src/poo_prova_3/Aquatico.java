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
public class Aquatico extends Veiculo{
    private float alturaProa;

    public Aquatico() {
    }

    public Aquatico(float alturaProa) {
        this.alturaProa = alturaProa;
    }

    public Aquatico(float alturaProa, LocalDate dataFabricacao) {
        super(dataFabricacao);
        this.alturaProa = alturaProa;
    }

    public float getAlturaProa() {
        return alturaProa;
    }

    public void setAlturaProa(float alturaProa) {
        this.alturaProa = alturaProa;
    }
    
    public void polimorfismo(){
        System.out.println("Polimorfismo Aquático");
    }
}

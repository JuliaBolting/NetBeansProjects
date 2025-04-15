/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_16_08_ex3;

/**
 *
 * @author Julia
 */
public class Quadrado {
    private float lado;

    public Quadrado() {
    }

    public Quadrado(float lado) {
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
    
    public float area(float lado){
        return lado * lado;
    }
    
    public float perimetro(float lado){
        return lado * 4;
    }
    
    public float verifyLado(float lado){
        if(lado <= 0) 
            return 0;
                else 
            return lado;
    }

    @Override
    public String toString() {
        return "Quadrado{" + "lado=" + lado + " area=" + area(lado) + " perimetro="  + perimetro(lado) + "}";
    }
}

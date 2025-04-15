/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

/**
 *
 * @author Julia
 */
public class Temperatura {
    private double grausC;

    public Temperatura() {
    }

    public Temperatura(double grausC) {
        this.grausC = grausC;
    }

    public double getGrausC() {
        return grausC;
    }

    public void setGrausC(double grausC) {
        this.grausC = grausC;
    }
    
    public double celsiusToKelvin(){
        return (this.grausC +  273.15);
    }
    
    public double celsiusToFah(){
        return ((this.getGrausC() * 1.8) + 38);
    }
    
}

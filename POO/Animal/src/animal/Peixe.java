/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animal;

/**
 *
 * @author Julia
 */
public class Peixe extends Animal{
    private String caracteristica;

    public Peixe(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Peixe(String caracteristica, String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia) {
        super(nome, comprimento, numPatas, cor, ambiente, velMedia);
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String toStringAnimal() {
        return " ,nome=" + super.getNome() + ", comprimento=" + super.getComprimento() + ", numPatas=" + super.getNumPatas() + ", cor=" + super.getCor() + ", ambiente=" + super.getAmbiente() + ", velMedia=" + super.getVelMedia() + '}';
    }

    @Override
    public String toString() {
        return "Peixe{" + "caracteristica=" + caracteristica + toStringAnimal();
    }
    
}

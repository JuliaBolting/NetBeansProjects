/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animal;

/**
 *
 * @author Julia
 */
public class Mamifero extends Animal {

    private String alimento;

    public Mamifero(String alimento) {
        this.alimento = alimento;
    }

    public Mamifero(String alimento, String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia) {
        super(nome, comprimento, numPatas, cor, ambiente, velMedia);
        this.alimento = alimento;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String toStringAnimal() {
        return " ,nome=" + super.getNome() + ", comprimento=" + super.getComprimento() + ", numPatas=" + super.getNumPatas() + ", cor=" + super.getCor() + ", ambiente=" + super.getAmbiente() + ", velMedia=" + super.getVelMedia() + '}';
    }

    @Override
    public String toString() {
        return "Mamifero{" + "alimento=" + alimento + toStringAnimal();
    }

}

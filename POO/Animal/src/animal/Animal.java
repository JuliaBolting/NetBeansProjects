/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animal;

/**
 *
 * @author Julia
 */
public class Animal {
    private String nome;
    private double comprimento;
    private int numPatas;
    private String cor;
    private String ambiente;
    private double velMedia;

    public Animal() {
    }

    public Animal(String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.numPatas = numPatas;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velMedia = velMedia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public double getVelMedia() {
        return velMedia;
    }

    public void setVelMedia(double velMedia) {
        this.velMedia = velMedia;
    }

    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + ", comprimento=" + comprimento + ", numPatas=" + numPatas + ", cor=" + cor + ", ambiente=" + ambiente + ", velMedia=" + velMedia + '}';
    }
    
}

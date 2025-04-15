/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisaodoo;

/**
 *
 * @author Julia
 */
public class Aluno {
    private String nome;
    private double altura;
    private double peso;

    public Aluno() {
    }

    public Aluno(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public int verifyAltura(double altura){
        if(altura < 0 || altura > 3.0){
            System.out.println("Informe a altura entre 0 e 3 metros");
            return 1;
        } else {
            this.setAltura(altura);
            return 0;
        }
    }
    
    public int verifyPeso(double peso){
        if(peso < 0){
            System.out.println("Informe o peso maior que 0");
            return 1;
        } else {
            this.setPeso(peso);
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", altura=" + altura + ", peso=" + peso + '}';
    }
    
    
}

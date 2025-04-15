/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio6;

/**
 *
 * @author Julia
 */
public class Cidade {
    private String nome;
    private int populacao;
    private String clima;
    private float area;
    
    public Cidade(){}

    public Cidade(String nome, int populacao, String clima, float area) {
        this.nome = nome;
        this.populacao = populacao;
        this.clima = clima;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_16_08_ex4;

/**
 *
 * @author Julia
 */
public class Produto {
    private String nome;
    private int cod;
    private String categoria;
    private float precoCusto;

    public Produto() {
    }

    public Produto(String nome, int cod, String categoria, float precoCusto) {
        this.nome = nome;
        this.cod = cod;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    public float precoVenda(float precoCusto){
        return (precoCusto * 30 / 100) + precoCusto;
    }
    
    public float imposto(float precoVenda){
        return precoVenda * 10 / 100;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", cod=" + cod + ", categoria=" + categoria + ", precoCusto=" + precoCusto + ", precoVenda=" + precoVenda(precoCusto) + ", imposto=" + imposto(precoVenda(precoCusto)) + "}";
    }
            
}

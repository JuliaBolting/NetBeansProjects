/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_3;

/**
 *
 * @author Julia
 */
public class Auxiliar {
    private String tipo;
    private String dadoVec;
    private String data;

    public Auxiliar(String tipo, String dadoVec, String data) {
        this.tipo = tipo;
        this.dadoVec = dadoVec;
        this.data = data;
    }

    public Auxiliar() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDadoVec() {
        return dadoVec;
    }

    public void setDadoVec(String dadoVec) {
        this.dadoVec = dadoVec;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}

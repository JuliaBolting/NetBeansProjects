/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio2;

/**
 *
 * @author Julia
 */
public class Filme {
    private String titulo;
    private int duracaoEmMinutos;

    public Filme() {
    }

    public Filme(String titulo, int duracaoEmMinutos) {
        this.titulo = titulo;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    
    public String exibirDuracaoEmHoras(int minutos, String titulo){
        int horas = minutos / 60;
        int restMinutos = minutos % 60;
        return "O filme " + titulo + " possui " + horas + " horas e " + restMinutos + " minutos de duração.";
    }
    
}

package Exercicio_10;

import java.time.LocalDate;

/**
 *
 * @author Julia
 */
public class Automovel {
    private String marca;
    private float kmInicial;
    private float kmFinal;
    private double litrosConsum;
    private LocalDate dataFabricacao;
    private double capCombustivel;
    
    public Automovel(){}

    public Automovel(String marca, float kmInicial, float kmFinal, double litrosConsum, LocalDate dataFabricacao, double capCombustivel) {
        this.marca = marca;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.litrosConsum = litrosConsum;
        this.dataFabricacao = dataFabricacao;
        this.capCombustivel = capCombustivel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(float kmInicial) {
        this.kmInicial = kmInicial;
    }

    public float getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(float kmFinal) {
        this.kmFinal = kmFinal;
    }

    public double getLitrosConsum() {
        return litrosConsum;
    }

    public void setLitrosConsum(double litrosConsum) {
        this.litrosConsum = litrosConsum;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public double getCapCombustivel() {
        return capCombustivel;
    }

    public void setCapCombustivel(double capCombustivel) {
        this.capCombustivel = capCombustivel;
    }
    
    public float calcKmRodado(float kmInicial, float kmFinal){
        return kmFinal - kmInicial;
    }
    
    public float calcConsumoMedio(float kmInicial, float kmFinal, double capTanque, double litrosCons){
        return (float) (calcKmRodado(kmInicial, kmFinal) / litrosCons);
    }
    
    public float calcAutonomia(float kmInicial, float kmFinal, double capTanque, double litrosCons){
        return (float) (calcKmRodado(kmInicial, kmFinal) / ( capTanque - litrosCons));
    }

    @Override
    public String toString() {
        return "Automovel{" + "marca=" + marca + ", kmInicial=" + kmInicial + ", kmFinal=" + kmFinal + ", litrosConsum=" + litrosConsum + ", dataFabricacao=" + dataFabricacao + ", capCombustivel=" + capCombustivel + ", consumoMedio=" + calcAutonomia(kmInicial, kmFinal, capCombustivel, litrosConsum) + ", autonomia=" + calcAutonomia(kmInicial, kmFinal, capCombustivel, litrosConsum) + '}';
    }
    
    
    
}

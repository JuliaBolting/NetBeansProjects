/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */

public class AgenciaPlus extends Agencia {

    private double saldoMinimo;
    private double saldoMaximo;
    
    public AgenciaPlus(String num, Banco bc, double saldoMinimo, double saldoMaximo) {
        super(num, bc);
        this.saldoMinimo = saldoMinimo;
        this.saldoMaximo = saldoMaximo;
    }
    
    public double getSaldoMaximo() {
        return saldoMaximo;
    }

    public void setSaldoMaximo(double saldoMaximo) {
        this.saldoMaximo = saldoMaximo;
    }
    
    public double getSaldoMinimo() {
        return saldoMinimo;
    }
    
    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }
    
    // solucao
    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < saldoMinimo) {
            contaEspecial.setLimite(contaEspecial.getLimite() * .75);
        } else if (contaEspecial.getSaldo() > saldoMaximo) {
            contaEspecial.setLimite(contaEspecial.getLimite() * 1.25);
        }
    }
}


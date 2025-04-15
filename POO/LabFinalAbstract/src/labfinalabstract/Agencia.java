/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
a) Que métodos podem ser invocados diretamente sobre um objeto da classe Agencia?
* Todos os métodos que estiverem abstratos
b) Como é possível invocar o método ajustarLimiteIndividual?
* Por que o protected permite que classes herdeiras tenham acesso ao método declarado
c) O que levou o projetista da classe Agencia a aplicar o modificador abstract no método
ajustarLimiteIndividual?
* Para que as classes que herdam Agencia conseguissem alcançar o método ajustarLimiteIndividual
 */

public abstract class Agencia {

    private String numero;
    private Banco banco;

    public Agencia(String num, Banco bc) {
        numero = num;
        banco = bc;
    }

    public Banco getBanco() {
        return banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setBanco(Banco b) {
        banco = b;
    }

    public void setNumero(String num) {
        numero = num;
    }
    
    /**
     * Metodo para impressao de todos os dados da classe
     */
    public void imprimeDados() {
        System.out.println("Agencia no. " + numero);
        banco.imprimeDados();
    }
    
    public void ajustarLimites(ContaEspecial[] contasEspeciais) {
        System.out.println("===================================================================");
        System.out.println("Agencia: " + this.getNumero() + " ajustando limites");
        for (ContaEspecial ce : contasEspeciais) {
            if (ce != null) {
                if (ce.getAgencia() != this) {
                    System.out.println("A conta " + ce.getNumero() + " nao pertence a esta agencia");
                } else {
                    double limiteAntigo = ce.getLimite();
                    ajustarLimiteIndividual(ce); // metodo abstrato
                    double limiteAjustado = ce.getLimite();
                    System.out.println("conta " + ce.getNumero() +
                            "\tlimite antigo: " + limiteAntigo +
                            "\tlimite ajustado: " + limiteAjustado);
                }
            }
        }
        System.out.println("limites ajustados");
        System.out.println("===================================================================");

        
    }
    
    protected abstract void ajustarLimiteIndividual(ContaEspecial contaEspecial);

}

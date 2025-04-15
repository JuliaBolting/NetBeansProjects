/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labfinalabstract;

/**
 *
 * @author Julia
 */
/*
 * 
 * 1) Modifique esta classe para que herde de Agencia
 * 
 * 2) Acrescente um construtor valido. 
 * 
 * 3) Sobrescreva o metodo abstrato ajustarLimiteIndividual
 *    de acordo com as seguintes regras de negocio:
 *    
 *    a) se o saldo estiver negativo, abaixo de -5000.00 o limite deve ser ajustado para 1000.00
 *    b) se o saldo estiver positivo, abaixo de +5000.00 o limite deve ser ajustado para 30% do saldo  
 *    c) se o saldo estiver positivo, acima de  +5000.00 o limite deve ser ajustado para 50% do saldo
 * 
 */
public abstract class AgenciaPremium extends Agencia{
    private String numeroP;
    private Banco bancoP;

    public AgenciaPremium(String numeroP, Banco bancoP, String num, Banco bc) {
        super(num, bc);
        this.numeroP = numeroP;
        this.bancoP = bancoP;
    }

    public AgenciaPremium(String num, Banco bc) {
        super(num, bc);
    }

    public String getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(String numeroP) {
        this.numeroP = numeroP;
    }

    public Banco getBancoP() {
        return bancoP;
    }

    public void setBancoP(Banco bancoP) {
        this.bancoP = bancoP;
    }
    
    @Override
    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < -5000) {       // a
            contaEspecial.setLimite(1000);
        } else if (contaEspecial.getSaldo() < 5000) { // b
            contaEspecial.alterarLimiteSoPorcentagem(30, contaEspecial.getSaldo() );
        } else if (contaEspecial.getSaldo() > 5000) { // c
            contaEspecial.alterarLimiteSoPorcentagem(50, contaEspecial.getSaldo() );
        } 
    }


}


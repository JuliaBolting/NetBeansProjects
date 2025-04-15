/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

/**
 *
 * @author Julia
 */

public class AgenciaPremium /* solucao -> */ extends Agencia {

    public AgenciaPremium(String num, Banco bc) {
        super(num, bc);
    }

    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < -5000d) {
            contaEspecial.setLimite(1000d);
        } else if (contaEspecial.getSaldo() < 5000d) {
            contaEspecial.setLimite(contaEspecial.getSaldo() * .3);
        } else if (contaEspecial.getSaldo() > 5000d) {
            contaEspecial.setLimite(contaEspecial.getSaldo() * .5);
        }
    }
}


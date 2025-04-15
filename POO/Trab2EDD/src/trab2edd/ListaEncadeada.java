/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab2edd;

/**
 *
 * @author Julia
 */
public class ListaEncadeada {

    private Ficha ficha;
    private Ficha lastE;

    public ListaEncadeada() {
        this.ficha = null;
        this.lastE = null;
    }

    public void organizarFila(Ficha mficha) {
        if ("U".equals(mficha.getCor())) {
            insereVermelhaOdeN(mficha);
        } else {
            insereAzulOde1(mficha);
        }
    }

    public void insereAzulOde1(Ficha mficha) {
        if (this.ficha == null) {
            this.ficha = mficha;
        }
        if (this.lastE == null) {
            this.lastE = mficha;
            this.lastE.setUltimoElemento(mficha);
        } else {

            this.lastE.getUltimoElemento().setProx(mficha);
            this.lastE.setUltimoElemento(mficha);
        }
    }

    public void insereVermelhaOdeN(Ficha mficha) {
        if (this.ficha == null) {
            this.ficha = mficha;
        } else {
            switch (mficha.getNum()) {
                case 1 -> {
                    mficha.setProx(this.ficha);
                    this.ficha = mficha;
                }
                case 2 -> {
                    Ficha aux = this.ficha;
                    mficha.setProx(aux.getProx());
                    aux.setProx(mficha);
                }
                default -> {
                    int index = 2;
                    Ficha aux = this.ficha;
                    while (mficha.getNum() > index) {
                        aux = aux.getProx();
                        index++;
                    }
                    mficha.setProx(aux.getProx());
                    aux.setProx(mficha);
                }
            }

            if (this.lastE == null) {
                this.lastE = mficha;
                this.lastE.setUltimoElemento(mficha);
            } else {
                if (!"N".equals(this.lastE.getUltimoElemento().getCor())) {
                    this.lastE.setUltimoElemento(mficha);
                }
            }
        }
    }

    public void mostra() {
        if (this.ficha == null) {
            System.out.println("Lista vazia!");
        } else {

            Ficha aux = this.ficha;
            while (aux != null) {
                System.out.printf(aux.getNum() + "-" + aux.getCor() + ", ");
                aux = aux.getProx();
            }
        }

    }

    public void resetLista() {
        this.ficha = null;
        this.lastE = null;
    }

}

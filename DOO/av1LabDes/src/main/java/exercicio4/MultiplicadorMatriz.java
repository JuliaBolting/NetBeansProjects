/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio4;

/**
 *
 * @author Julia
 */
public class MultiplicadorMatriz implements Runnable {

    private int[][] mA;
    private int[][] mB;
    private int[][] res;
    private int linha;

    public MultiplicadorMatriz(int[][] mA, int[][] mB, int[][] res, int linha) {
        this.mA = mA;
        this.mB = mB;
        this.res = res;
        this.linha = linha;
    }

    public int[][] getmA() {
        return mA;
    }

    public void setmA(int[][] mA) {
        this.mA = mA;
    }

    public int[][] getmB() {
        return mB;
    }

    public void setmB(int[][] mB) {
        this.mB = mB;
    }

    public int[][] getRes() {
        return res;
    }

    public void setRes(int[][] res) {
        this.res = res;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    @Override
    public void run() {
        for (int j = 0; j < mB[0].length; j++) {
            int soma = 0;
            for (int k = 0; k < mA[0].length; k++) {
                soma += mA[linha][k] * mB[k][j];
            }
            res[linha][j] = soma;
        }
    }

}

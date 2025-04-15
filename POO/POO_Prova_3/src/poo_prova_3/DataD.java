/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_prova_3;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class DataD {
    private ArrayList<Auxiliar> listDta = new ArrayList();

    public DataD() {
    }

    public ArrayList<Auxiliar> getListDta() {
        return listDta;
    }

    public void setListDta(ArrayList<Auxiliar> listDta) {
        this.listDta = listDta;
    }

    public void addDataList(Auxiliar aux) {
        listDta.add(aux);
    }
    
}

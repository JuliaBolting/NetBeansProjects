/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.entity;

/**
 *
 * @author Julia
 */
public class InformationDTO {
    
    private int id;
    private String name;
    private String state;
    private String country;

    public InformationDTO() {
    }

    public InformationDTO(int id, String name, String state, String country) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
    }

    public int getIdCidade() {
        return id;
    }

    public void setIdCidade(int idCidade) {
        this.id = idCidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}

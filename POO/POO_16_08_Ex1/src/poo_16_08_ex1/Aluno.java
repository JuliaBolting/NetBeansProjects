/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_16_08_ex1;

/**
 *
 * @author Julia
 */
public class Aluno {

    private long CPF;
    private String nome;
    private String email;
    
    public Aluno(){
        //this.CPF = 1;
    }

    public Aluno(long CPF, String nome, String email) {
        this.CPF = CPF;
        this.email = email;
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" + "CPF=" + CPF + ", nome=" + nome + ", email=" + email + '}';
    }
    
    

}

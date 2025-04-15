/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author Julia
 */
public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + super.getNome() + ", telefone=" + super.getTelefone() + ", endereco=" + super.getEndereco() + " PessoaFisica{" + "cpf=" + cpf + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author Julia
 */
public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + super.getNome() + ", telefone=" + super.getTelefone() + ", endereco=" + super.getEndereco() + " PessoaJuridica{" + "cnpj=" + cnpj + '}';
    }
    
}

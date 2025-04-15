/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgabstract;

/**
 *
 * @author Julia
 */
public class TestarPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaJuridica pj = new PessoaJuridica();
        PessoaFisica pf = new PessoaFisica();
        
        pj.setNome("Primeiro");
        pj.setTelefone("44 988888888");
        pj.setEndereco("endereco endereco endereco endereco endereco");
        pj.setCnpj("78.145.0001/45");
        
        System.out.println(pj.toString());
        System.out.println("----------------------");
        
        pf.setNome("Segundo");
        pf.setTelefone("44 777777777");
        pf.setEndereco("endereco2 endereco 2endereco 2endereco 2endereco");
        pf.setCpf("145.12.751-44");
        
        System.out.println(pf.toString());
        
        
        
    }
    
}

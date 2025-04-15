package poo_16_08_ex1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
Utilize a IDE NetBeans, crie um projeto Java e resolva os itens abaixo:
a) Crie a classe Aluno
b) Defina e especifique três atributos para um aluno e, para cada um deles, crie métodos de
acesso (get) e métodos de atualização (set)
c) Crie dois construtores: um vazio e outro com possibilidade de atribuir valores
d) Crie um método toString()
e) Crie dois objetos (aluno1 e aluno2). Inicialize o aluno1 com o construtor vazio e o aluno 2
com o construtor com possibilidade de atribuir valores. Mostre o estado de cada um deles
após a criação
f) Utilizando a entrada de dados via teclado (Scanner) atribua novos valores para o aluno2,
depois apresente o estado do aluno2
g) Ajuste o método setAltura para que uma altura informada seja maior que 0 e menor igual
a 3 metros e o método peso para aceitar valores positivos (maior que zero).
 */
public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Aluno aluno = new Aluno();
        
        String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
        aluno.setNome(nome);
        
        String cpf = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
        aluno.setCPF(Long.parseLong(cpf));
        
        String email = JOptionPane.showInputDialog("Informe o email do aluno: ");
        aluno.setEmail(email);
        
        
        JOptionPane.showMessageDialog(null, aluno.toString());
    }
    
}

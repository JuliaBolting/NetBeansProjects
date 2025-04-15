package poo_16_08_ex4;

import javax.swing.JOptionPane;

/**
Crie um programa orientado a objetos, que para um dado produto (nome, código, categoria,
preço custo e preço de venda) faça:
a) Crie uma classe para modelar dados de um produto;
b) Crie um método para calcular o preço de venda de um produto. O preço de venda deve ser
gerado acrescentando 30% ao preço de custo. Um preço de custo deve ser maior ou igual a
zero;
c) Crie um método de classe – privado para calcular o imposto a ser pago. 
* Sempre que o método para o cálculo do preço de venda for executado, o cálculo do 
* imposto deve ser chamado e executado.
Obs.: Use o comando:
JOptionPane.showMessageDialog(null, objeto.toString());
 */
public class main {

    public static void main(String[] args) {
        Produto prod = new Produto();
        
        String nome = JOptionPane.showInputDialog("Informe o nome do produto: ");
        prod.setNome(nome);
        
        String cod = JOptionPane.showInputDialog("Informe o código do produto: ");
        prod.setCod(Integer.parseInt(cod));
        
        String categoria = JOptionPane.showInputDialog("Informe a categoria do produto: ");
        prod.setCategoria(categoria);
        
        String precoCustoQ;
        float precoCusto;
        do{
        precoCustoQ = JOptionPane.showInputDialog("Informe o preço de custo do produto: ");
        precoCusto = Float.parseFloat(precoCustoQ);
        }while(precoCusto < 0);
        
        prod.setPrecoCusto(precoCusto);
        
        JOptionPane.showMessageDialog(null, prod.toString());
    }
    
}

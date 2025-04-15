/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animal;

/**
 *
 * @author Julia
 */
public class TestarAnimais {
    
    public static void main(String[] args) {
        Mamifero camelo = new Mamifero("leite", "Camelo", 150, 4, "Amarelo", "Terra", 2);
        Peixe tubarao = new Peixe("cauda", "Tilapia", 20, 0, "Cinzento", "Mar", 1.5);
        Mamifero ursocanada = new Mamifero("Mel", "Urso-do-Canadá", 180, 4, "Vermelho", "Terra", 0.5);
        
        System.out.println(camelo.toString());
        System.out.println(tubarao.toString());
        System.out.println(ursocanada.toString());
        
        
    }
    
}

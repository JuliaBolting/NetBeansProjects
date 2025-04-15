/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class TestarFilme {

    public static void main(String[] args) {
        Filme umFilmeQualquer = new Filme();   
        Filme meuFilmeFavorito = new Filme();   
        String filmeFavorito = "V de Vingança";
        
        umFilmeQualquer.setDuracaoEmMinutos(142);
        umFilmeQualquer.setTitulo("Os Vingadores");
        
        JOptionPane.showMessageDialog(null, 
        umFilmeQualquer.exibirDuracaoEmHoras(umFilmeQualquer.getDuracaoEmMinutos(), umFilmeQualquer.getTitulo())
        );
        
        //
        meuFilmeFavorito.setTitulo(filmeFavorito);
        meuFilmeFavorito.setDuracaoEmMinutos(100);
        
                        JOptionPane.showMessageDialog(null, 
        meuFilmeFavorito.exibirDuracaoEmHoras(meuFilmeFavorito.getDuracaoEmMinutos(), filmeFavorito)
        );
                
        meuFilmeFavorito.setDuracaoEmMinutos(132);
        
                        JOptionPane.showMessageDialog(null, 
        meuFilmeFavorito.exibirDuracaoEmHoras(meuFilmeFavorito.getDuracaoEmMinutos(), meuFilmeFavorito.getTitulo())
        );
                
                        JOptionPane.showMessageDialog(null, 
        "Os filmes no catálogo são " + umFilmeQualquer.getTitulo() + " e " + filmeFavorito
        );
    }
    
}

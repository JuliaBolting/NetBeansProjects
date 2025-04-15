package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.dao.BaseFrame;
import javax.swing.*;
import java.awt.*;

public class CidadeCatastrofe extends BaseFrame {

    public CidadeCatastrofe() {
        
        super("Cidade Catástrofe", 800, 600);
        setupTitle("Cidade Catástrofe");
        String pathAbsoluteImage = "C:\\Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\DOO\\TrabTempo\\src\\main\\java\\util\\";
        JLabel lblImagem = new JLabel(new ImageIcon(pathAbsoluteImage + "lagesMapaInundacoes.png"));
        lblImagem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblImagem, BorderLayout.CENTER);
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CidadeCatastrofe().setVisible(true));
    }
}
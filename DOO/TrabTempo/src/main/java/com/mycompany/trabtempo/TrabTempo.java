package com.mycompany.trabtempo;

import com.mycompany.trabtempo.entity.UsuarioDTO;
import com.mycompany.trabtempo.ui.Login;
import data.SerializationUtil;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrabTempo extends JFrame {
    private UsuarioDTO userDto;

    public TrabTempo() {
        setTitle("Trabalho de Tempo");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adicionar o WindowListener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Salvar o estado do usuário
                if (userDto != null) {
                    SerializationUtil.saveUser(userDto, "user_data.ser");
                }
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrabTempo trabTempo = new TrabTempo();
            trabTempo.setVisible(false);
            
            // Inicializar a tela de login
            new Login().setVisible(true);
        });
    }
}
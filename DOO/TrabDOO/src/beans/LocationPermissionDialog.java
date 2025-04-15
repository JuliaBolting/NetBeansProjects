/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Julia
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LocationPermissionDialog extends JFrame {
    private JLabel permissionLabel;

    public LocationPermissionDialog() {
        setTitle("Permissão de Localização");
        setSize(new Dimension(300, 100));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        permissionLabel = new JLabel("Por favor, conceda permissão de localização.");
        add(permissionLabel);
    }

    public String getEstadoUsuario() {
        // Simulação de obtenção do estado do usuário (substituir com lógica real)
        return "Santa Catarina"; // Exemplo de retorno
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class ImagePanel extends JPanel {
    private Image image;

    // Construtor padrão
    public ImagePanel() {
        // Você pode definir uma imagem padrão ou deixar nulo
    }

    // Construtor que aceita um parâmetro Image
    public ImagePanel(Image image) {
        this.image = image;
    }

    // Método para definir uma imagem
    public void setImage(Image image) {
        this.image = image;
        repaint(); // Redesenha o painel após definir a imagem
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

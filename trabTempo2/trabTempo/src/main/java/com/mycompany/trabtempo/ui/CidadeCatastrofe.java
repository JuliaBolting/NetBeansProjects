package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.dao.BaseFrame;
import com.mycompany.trabtempo.dao.CidadeDAO;
import com.mycompany.trabtempo.entity.CidadeDTO;
import com.mycompany.trabtempo.entity.InformationDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CidadeCatastrofe extends BaseFrame {

    private JTextPane txtPaneDesastres;

    public CidadeCatastrofe() {
        super("Cidade Catástrofe", 800, 600);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230));
        add(mainPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(173, 216, 230));
        JLabel lblTitle = new JLabel("Cidade Catástrofe", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLACK);
        titlePanel.add(lblTitle, BorderLayout.CENTER);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        txtPaneDesastres = new JTextPane();
        txtPaneDesastres.setContentType("text/html");
        txtPaneDesastres.setFont(new Font("Arial", Font.PLAIN, 14));
        txtPaneDesastres.setEditable(false);
        txtPaneDesastres.setBackground(new Color(173, 216, 230));
        txtPaneDesastres.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(txtPaneDesastres);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel imageContainerPanel = new JPanel();
        imageContainerPanel.setBackground(new Color(173, 216, 230)); // Azul claro
        imageContainerPanel.setLayout(new BorderLayout());

        mainPanel.add(imageContainerPanel, BorderLayout.SOUTH);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(135, 206, 250)); // Azul claro
        btnVoltar.setForeground(Color.BLACK);
        btnVoltar.addActionListener((ActionEvent e) -> {
            new Tempo(new InformationDTO()).setVisible(true);
            dispose();
        });

        JButton btnVisualizarMapa = new JButton("Visualizar Mapa");
        btnVisualizarMapa.setBackground(new Color(135, 206, 250));
        btnVisualizarMapa.setForeground(Color.BLACK);
        btnVisualizarMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMapWindow();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnVoltar);
        buttonPanel.add(btnVisualizarMapa);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        loadCatastrofes();
    }

    private void loadCatastrofes() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<CidadeDTO> catastrofes = cidadeDAO.getCatastrofes();

        StringBuilder texto = new StringBuilder();
        for (CidadeDTO catastrofe : catastrofes) {
            texto.append(String.format("%s - <b>%s</b><br>   - Descrição: %s<br><br>",
                    catastrofe.getAno(), catastrofe.getTitulo(), catastrofe.getDescricao()));
        }

        if (txtPaneDesastres != null) {
            txtPaneDesastres.setText("<html>" + texto.toString() + "</html>");
        } else {
            System.err.println("txtPaneDesastres não está inicializado.");
        }
    }

    private void openMapWindow() {
        JFrame mapFrame = new JFrame("Mapa das áreas sucetíveis à inundações em Lages, SC");
        mapFrame.setSize(800, 600);
        mapFrame.setLocationRelativeTo(null);
        mapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBackground(new Color(173, 216, 230));
        mapFrame.add(mapPanel);

        JLabel lblImagem = new JLabel();
        ImageIcon originalIcon = new ImageIcon("src/main/java/util/MapaLagesIn.png");

        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(800, 600, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        lblImagem.setIcon(scaledIcon);
        lblImagem.setHorizontalAlignment(JLabel.CENTER);
        mapPanel.add(lblImagem, BorderLayout.CENTER);

        mapFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CidadeCatastrofe().setVisible(true));
    }
}

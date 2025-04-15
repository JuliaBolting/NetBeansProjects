package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.entity.InformationDTO;
import com.mycompany.trabtempo.rest.PrevisaoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tempo extends JFrame {

    private final PrevisaoService previsaoService = new PrevisaoService();
    private final InformationDTO info;
    private final String diaAtual;
    private JScrollPane scrollPane;

    public Tempo(InformationDTO info) {
        this.info = info;
        this.diaAtual = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Previsão do Tempo");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color buttonColor = new Color(173, 216, 230);
        Color buttonColorWhite = new Color(135, 206, 250);

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(buttonColor);
        centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(centralPanel, BorderLayout.CENTER);

        JLabel lblCidade = new JLabel(info.getName(), JLabel.CENTER);
        lblCidade.setFont(new Font("Arial", Font.BOLD, 30));
        lblCidade.setForeground(Color.BLACK);
        lblCidade.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblCidade);

        JLabel lblTitulo = new JLabel("Previsão do Tempo", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblTitulo);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.setBackground(buttonColorWhite);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        centralPanel.add(scrollPane);

        JButton btnVisualizarMapa = new JButton("Catástrofes");
        btnVisualizarMapa.setBackground(buttonColorWhite);
        btnVisualizarMapa.setForeground(Color.BLACK);
        btnVisualizarMapa.addActionListener((ActionEvent e) -> {
            new CidadeCatastrofe().setVisible(true);
            dispose();
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(buttonColorWhite);
        btnVoltar.setForeground(Color.BLACK);
        btnVoltar.addActionListener((ActionEvent e) -> {
            new VerificarEstado().setVisible(true);
            dispose();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnVoltar);
        buttonPanel.add(btnVisualizarMapa);

        add(buttonPanel, BorderLayout.SOUTH);

        loadWeatherData();
    }

    private void loadWeatherData() {
        new SwingWorker<JSONObject, Void>() {
            @Override
            protected JSONObject doInBackground() throws Exception {
                try {
                    return previsaoService.fetchPrevisao(info.getName(), info.getCountry());
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Tempo.this, "Erro ao carregar os dados da previsão.");
                    return new JSONObject();
                }
            }

            @Override
            protected void done() {
                try {
                    JSONObject response = get();
                    if (response == null || response.isEmpty()) {
                        JOptionPane.showMessageDialog(Tempo.this, "Nenhum dado retornado.");
                        return;
                    }
                    updateUIWithWeatherData(response);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Tempo.this, "Erro ao processar os dados da previsão.");
                }
            }
        }.execute();
    }

    private void updateUIWithWeatherData(JSONObject response) {
        JPanel panel = (JPanel) scrollPane.getViewport().getView();
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(new Color(135, 206, 250));

        JSONArray periods = response.optJSONArray("response")
                .optJSONObject(0)
                .optJSONArray("periods");

        if (periods == null) {
            JOptionPane.showMessageDialog(Tempo.this, "Dados de previsão não encontrados.");
            return;
        }

        for (int i = 0; i < periods.length(); i++) {
            JSONObject period = periods.optJSONObject(i);

            String date = period.optString("dateTimeISO", "").split("T")[0];
            String weather = period.optString("weather", "N/A");
            String rain = period.optDouble("precipMM", 0.0) + " mm";
            String temperature = "Máx: " + period.optDouble("maxTempC", 0.0) + "°C / Mín: " + period.optDouble("minTempC", 0.0) + "°C";
            String feelsLike = "Sensação térmica: " + period.optDouble("feelslikeC", 0.0) + "°C";
            String windSpeed = "Vento: " + period.optDouble("windSpeedKPH", 0.0) + " km/h";

            String translatedWeather = translateWeather(weather);
            String pathAbsoluteIcon = "src/main/java/util/";

            boolean isHoje = date.equals(diaAtual);
            JPanel diaPanel = createDiaPanel(date, pathAbsoluteIcon + period.optString("icon", ""), translatedWeather, rain, temperature, feelsLike, windSpeed, isHoje);
            panel.add(diaPanel);
        }

        scrollPane.setViewportView(panel);
        panel.revalidate();
        panel.repaint();
    }

    private String translateWeather(String weather) {
        String translatedWeather = weather;

        try {
            String targetLanguage = "PT";
            JSONObject response = previsaoService.translate(weather, targetLanguage);

            JSONArray translations = response.optJSONArray("translations");
            if (translations != null && translations.length() > 0) {
                translatedWeather = translations.getJSONObject(0).optString("text", weather);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(Tempo.this, "Erro ao traduzir o texto do clima.");
        }

        return translatedWeather;
    }

    private JPanel createDiaPanel(String dia, String imgFile, String tempo, String chuva, String temperatura, String sensaçãoTérmica, String vento, boolean isHoje) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(200, 300));
        panel.setBorder(BorderFactory.createLineBorder(isHoje ? Color.BLUE : Color.GRAY));
        panel.setBackground(isHoje ? new Color(135, 206, 250) : Color.WHITE);
        panel.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblDia = new JLabel(getDayOfWeek(dia));
        lblDia.setFont(new Font("Arial", Font.BOLD, 16));
        lblDia.setForeground(Color.BLACK);
        lblDia.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblDia, gbc);

        gbc.gridy = 1;
        try {
            File file = new File(imgFile);
            if (!file.exists()) {
                System.out.println("Arquivo de imagem não encontrado: " + file.getAbsolutePath());
            }

            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Erro ao carregar imagem: " + file.getAbsolutePath());
            }

            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            JLabel lblIcon = new JLabel(icon);
            lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblIcon, gbc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gbc.gridy = 2;
        JLabel lblTempo = new JLabel(tempo);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTempo.setForeground(Color.BLACK);
        lblTempo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTempo, gbc);

        gbc.gridy = 3;
        JLabel lblChuva = new JLabel("Chuva: " + chuva);
        lblChuva.setFont(new Font("Arial", Font.BOLD, 14));
        lblChuva.setForeground(Color.BLACK);
        lblChuva.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblChuva, gbc);

        gbc.gridy = 4;
        JLabel lblTemperatura = new JLabel(temperatura);
        lblTemperatura.setFont(new Font("Arial", Font.BOLD, 14));
        lblTemperatura.setForeground(Color.BLACK);
        lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTemperatura, gbc);

        gbc.gridy = 5;
        JLabel lblSensacaoTermica = new JLabel(sensaçãoTérmica);
        lblSensacaoTermica.setFont(new Font("Arial", Font.BOLD, 14));
        lblSensacaoTermica.setForeground(Color.BLACK);
        lblSensacaoTermica.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblSensacaoTermica, gbc);

        gbc.gridy = 6;
        JLabel lblVento = new JLabel(vento);
        lblVento.setFont(new Font("Arial", Font.BOLD, 14));
        lblVento.setForeground(Color.BLACK);
        lblVento.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblVento, gbc);

        return panel;
    }

    private String getDayOfWeek(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date dt = sdf.parse(date);
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
            return dayFormat.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
            return "Dia da Semana";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tempo(new InformationDTO()).setVisible(true)); // Alterar conforme necessário
    }
}

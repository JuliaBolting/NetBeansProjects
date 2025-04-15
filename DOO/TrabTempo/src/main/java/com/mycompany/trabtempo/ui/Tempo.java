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
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Adicionar o título da cidade
        JLabel lblCidade = new JLabel(info.getName(), JLabel.CENTER);
        lblCidade.setFont(new Font("Arial", Font.BOLD, 30));
        lblCidade.setForeground(Color.WHITE);
        lblCidade.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Margem superior
        add(lblCidade, BorderLayout.NORTH);

        // Adicionar o título da seção
        JLabel lblTitulo = new JLabel("Previsão do Tempo", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Margem inferior
        add(lblTitulo, BorderLayout.NORTH);

        // Criar painel de margens
        JPanel marginPanel = new JPanel();
        marginPanel.setLayout(new BorderLayout());
        marginPanel.setBackground(Color.DARK_GRAY);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens internas
        add(marginPanel, BorderLayout.CENTER);

        // Criar painel horizontal para previsões
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.setBackground(Color.DARK_GRAY);
        
        // Criar e adicionar o JScrollPane
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        marginPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnVisualizarMapa = new JButton("Visualizar Mapa");
        btnVisualizarMapa.addActionListener((ActionEvent e) -> {
            new CidadeCatastrofe().setVisible(true);
            dispose();
        });

        JPanel southPanel = new JPanel();
        southPanel.add(btnVisualizarMapa);
        add(southPanel, BorderLayout.SOUTH);

        loadWeatherData();
    }

    private void loadWeatherData() {
        new SwingWorker<JSONObject, Void>() {
            @Override
            protected JSONObject doInBackground() throws Exception {
                try {
                    // Solicita os dados da API
                    return previsaoService.fetchPrevisao(info.getName(), info.getCountry());
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Tempo.this, "Erro ao carregar os dados da previsão.");
                    return new JSONObject(); // Retorna um JSONObject vazio em caso de erro
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
        panel.setBackground(Color.DARK_GRAY);

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
            String pathAbsoluteIcon = "C:\\Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\DOO\\TrabTempo\\src\\main\\java\\util\\";

            JPanel diaPanel = createDiaPanel(date, pathAbsoluteIcon + period.optString("icon", ""), translatedWeather, rain, temperature, feelsLike, windSpeed, date.equals(diaAtual));
            panel.add(diaPanel);
        }

        // Atualizar o viewport do JScrollPane com o novo painel
        scrollPane.setViewportView(panel);
        panel.revalidate();
        panel.repaint();
    }

    private String translateWeather(String weather) {
        String translatedWeather = weather; // Valor padrão se a tradução falhar

        // Chama o serviço de tradução
        try {
            String targetLanguage = "PT"; // Define o idioma alvo (português)
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(200, 300));
        panel.setBorder(BorderFactory.createLineBorder(isHoje ? Color.blue : Color.GRAY));
        panel.setBackground(isHoje ? Color.blue : Color.DARK_GRAY);
        panel.setOpaque(true);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDia = new JLabel(getDayOfWeek(dia));
        lblDia.setFont(new Font("Arial", Font.BOLD, 16));
        lblDia.setForeground(Color.WHITE);
        lblDia.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblDia);

        try {
            // Verifica se o arquivo existe
            File file = new File(imgFile);
            if (!file.exists()) {
                System.out.println("Arquivo de imagem não encontrado: " + file.getAbsolutePath());
            }
            
            // Cria o ImageIcon
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Erro ao carregar imagem: " + file.getAbsolutePath());
            }
            
            JLabel lblImagem = new JLabel(icon);
            lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            lblImagem.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Margem superior e inferior
            panel.add(lblImagem);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
        }

        JLabel lblTempo = new JLabel(tempo);
        lblTempo.setForeground(Color.WHITE);
        lblTempo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTempo);

        JLabel lblChuva = new JLabel("Precipitação: " + chuva);
        lblChuva.setForeground(Color.WHITE);
        lblChuva.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblChuva);

        JLabel lblTemperatura = new JLabel(temperatura);
        lblTemperatura.setForeground(Color.WHITE);
        lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTemperatura);

        JLabel lblSensacaoTermica = new JLabel(sensaçãoTérmica);
        lblSensacaoTermica.setForeground(Color.WHITE);
        lblSensacaoTermica.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblSensacaoTermica);

        JLabel lblVento = new JLabel(vento);
        lblVento.setForeground(Color.WHITE);
        lblVento.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblVento);

        return panel;
    }

    private String getDayOfWeek(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", new Locale("pt", "BR"));
            return dayOfWeekFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Desconhecido";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tempo(new InformationDTO()).setVisible(true)); // Alterar conforme necessário
    }
}
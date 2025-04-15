package com.mycompany.trabtempo.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.trabtempo.entity.InformationDTO;
import com.mycompany.trabtempo.entity.UsuarioDTO;
import com.mycompany.trabtempo.rest.CidadeServer;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

public class VerificarEstado extends JFrame {

    private JComboBox<String> cbCidades;
    private JButton btnAvancar;
    private InformationDTO info = new InformationDTO();
    private List<InformationDTO> cidades; // Lista de cidades
    private CidadeServer cidadeServer; // Instância do serviço de cidade
    private UsuarioDTO userDto = new UsuarioDTO();

    public VerificarEstado() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Verificar Estado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel lblTitulo = new JLabel("Selecione sua Cidade", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo, BorderLayout.NORTH);

        // Instancia o serviço de cidades
        cidadeServer = new CidadeServer();

        // ComboBox de Cidades
        cbCidades = new JComboBox<>();
        cbCidades.setEditable(true);
        cbCidades.setPreferredSize(new Dimension(200, cbCidades.getPreferredSize().height)); // Definir tamanho preferido

        // Define um UI customizado para manter o dropdown aberto
        cbCidades.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                ComboPopup popup = super.createPopup();
                return popup;
            }
        });

        // Adiciona DocumentListener para filtrar cidades
        JTextField editor = (JTextField) cbCidades.getEditor().getEditorComponent();
        editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterCities();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterCities();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterCities();
            }

            private void filterCities() {
                String input = editor.getText();
                if (input.isEmpty()) {
                    // Se o input estiver vazio, mostramos todas as cidades
                    updateComboBox(cidades.stream().map(InformationDTO::getName).collect(Collectors.toList()));
                } else {
                    List<InformationDTO> filtered = cidades.stream()
                            .filter(cidade -> cidade.getName().toLowerCase().startsWith(input.toLowerCase()))
                            .collect(Collectors.toList());

                    if (filtered.isEmpty()) {
                        filtered.add(new InformationDTO(0, "Cidade não encontrada", "", ""));
                    }

                    List<String> filteredCityNames = filtered.stream().map(InformationDTO::getName).collect(Collectors.toList());
                    updateComboBox(filteredCityNames);

                    // Manter o texto digitado visível
                    if (!filteredCityNames.contains(input)) {
                        SwingUtilities.invokeLater(() -> {
                            editor.setText(input);
                            editor.setSelectionStart(input.length());
                            editor.setSelectionEnd(input.length());
                        });
                    }
                }
            }
        });

        // Adiciona KeyListener para manter o dropdown aberto
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!cbCidades.isPopupVisible()) {
                    cbCidades.showPopup(); // Força a exibição do popup
                }
            }
        });

        // Adiciona um FocusListener para garantir que o caret fique no final do texto
        editor.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextComponent comp = (JTextComponent) e.getSource();
                comp.setCaretPosition(comp.getText().length()); // Coloca o caret no final do texto
            }
        });

        // Painel para a caixa de texto
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(cbCidades);
        add(comboBoxPanel, BorderLayout.CENTER);

        // Painel para a imagem
        ImagePanel imagePanel = new ImagePanel();
        
        // Carregar e redimensionar a imagem
        String imagePath = "C:\\Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\DOO\\TrabTempo\\src\\main\\java\\util\\mapaSCRisco.png"; // Atualize o caminho conforme necessário
        ImageIcon imageIcon = new ImageIcon(imagePath);
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = imageIcon.getImage().getScaledInstance(600, 200, Image.SCALE_AREA_AVERAGING);
            imagePanel.setImage(image);
        } else {
            System.out.println("Erro ao carregar a imagem.");
        }
        
        imagePanel.setPreferredSize(new Dimension(600, 200)); // Ajuste a altura se necessário

        // Criar painel para a imagem e adicionar ao centro
        JPanel imagePanelContainer = new JPanel(new BorderLayout());
        imagePanelContainer.add(imagePanel, BorderLayout.CENTER);

        // Adicionar o painel da imagem ao CENTER e o painel de mensagens ao SOUTH
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(comboBoxPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanelContainer, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        // Criar um painel para os botões
        JPanel buttonPanel = new JPanel();
        
        // Botão Avançar
        btnAvancar = new JButton("Avançar");
        btnAvancar.setEnabled(true); // Inicialmente desativado
        btnAvancar.addActionListener((ActionEvent e) -> {
            System.out.println("btnAvancar ActionListener chamado"); // Mensagem de depuração
            String selectedCityName = (String) cbCidades.getSelectedItem();
            System.out.println("cidade " + selectedCityName);
            if (selectedCityName != null && !selectedCityName.equals("Cidade não encontrada")) {
                fetchCityIdAsync().thenRun(() -> {
                    if (info.getIdCidade() != 0) {
                        new Tempo(info).setVisible(true); // Passar a instância de InformationDTO
                        dispose();
                    } else {
                        System.out.println("Erro ao obter ID da cidade.");
                    }
                }).exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
            }
        });
        buttonPanel.add(btnAvancar);
        
        add(buttonPanel, BorderLayout.SOUTH);

        // Carregar cidades do estado ao iniciar
        loadCities(userDto.getUf()); // Substitua com o estado desejado
    }

    private void loadCities(String stateAbbr) {
        System.out.println("Carregando cidades para o estado: " + stateAbbr); // Mensagem de depuração
        try {
            JSONArray jsonArray = cidadeServer.fetchCidades(stateAbbr);
            cidades = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                cidades.add(new InformationDTO(
                        jsonObject.getInt("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("state"),
                        jsonObject.getString("country")
                ));
            }
            updateComboBox(cidades.stream().map(InformationDTO::getName).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Erro ao carregar cidades.");
        }
    }

    private CompletableFuture<Void> fetchCityIdAsync() {
        return CompletableFuture.runAsync(() -> {
            try {
                JSONArray jsonArray = cidadeServer.fetchCidades(userDto.getUf());
                Optional<InformationDTO> city = cidades.stream()
                        .filter(c -> c.getName().equals(cbCidades.getSelectedItem()))
                        .findFirst();
                if (city.isPresent()) {
                    info.setIdCidade(city.get().getIdCidade());
                    info.setName(city.get().getName());
                    info.setState(city.get().getState());
                    info.setCountry(city.get().getCountry());
                    System.out.println("cidade: " + info.getIdCidade());
                } else {
                    throw new Exception("Cidade não encontrada.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void updateComboBox(List<String> cityNames) {
        System.out.println("Atualizando ComboBox"); // Mensagem de depuração
        if (btnAvancar != null) {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cityNames.toArray(new String[0]));
            cbCidades.setModel(model);
            cbCidades.setSelectedItem(null); // Remove a seleção atual

            // Ativa o botão se houver cidades válidas
            boolean isEnabled = !cityNames.isEmpty() && cityNames.size() > 1;
            btnAvancar.setEnabled(isEnabled);
            System.out.println("btnAvancar ativado: " + isEnabled); // Mensagem de depuração
        } else {
            System.out.println("btnAvancar é null"); // Mensagem de depuração
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VerificarEstado().setVisible(true));
    }

    // Classe interna para o painel de imagem
    private class ImagePanel extends JPanel {
        private Image image;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }

        public void setImage(Image image) {
            this.image = image;
            repaint();
        }
    }
}
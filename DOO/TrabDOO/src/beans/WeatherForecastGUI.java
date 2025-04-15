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

public class WeatherForecastGUI extends JFrame {
    private JLabel locationLabel;
    private JTextArea weatherTextArea;

    public WeatherForecastGUI(String location, String weatherForecast) {
        setTitle("Previsão do Tempo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        locationLabel = new JLabel("Previsão do tempo para " + location);
        weatherTextArea = new JTextArea(weatherForecast);
        weatherTextArea.setEditable(false);
        weatherTextArea.setLineWrap(true);
        weatherTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(weatherTextArea);

        setLayout(new BorderLayout());
        add(locationLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Julia
 */
public class main {
    public static void main(String[] args) {
        LocationPermissionDialog permissionDialog = new LocationPermissionDialog();
        permissionDialog.setLocationRelativeTo(null);
        permissionDialog.setVisible(true);
        
        String estado = permissionDialog.getEstadoUsuario();
        permissionDialog.dispose();
        
        String weatherForecast = getWeatherForecastForEstado(estado);
        
        WeatherForecastGUI weatherForecastGUI = new WeatherForecastGUI(estado, weatherForecast);
        weatherForecastGUI.setLocationRelativeTo(null);
        weatherForecastGUI.setVisible(true);
    }

    private static String getWeatherForecastForEstado(String estado) {
        return "Previsão do tempo para " + estado + ":\n" +
                "Segunda-feira: Ensolarado\n" +
                "Terça-feira: Chuva fraca\n" +
                "Quarta-feira: Nublado\n" +
                "Quinta-feira: Ensolarado\n" +
                "Sexta-feira: Chuvas isoladas\n" +
                "Sábado: Parcialmente nublado\n" +
                "Domingo: Ensolarado";
    }
}


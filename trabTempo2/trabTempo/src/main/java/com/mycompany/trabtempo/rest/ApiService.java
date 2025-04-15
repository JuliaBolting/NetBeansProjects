package com.mycompany.trabtempo.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    protected String makeRequest(String endpoint) throws IOException {
        String token = "efdfafcd37b810130306515cfeb0abab";
        URL url = new URL(endpoint + "&token=" + token);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode + " - " + connection.getResponseMessage());
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            if (response.length() == 0) {
                throw new IOException("A resposta da API está vazia.");
            }

            return response.toString();
        }
    }

    protected String make2Request(String endpoint) throws IOException {
        String client_id = "Ni71pgi9cctOIUKaVOYEX";
        String client_secret = "ruEFQPud9syGGQjn0xx5O4iTrYIICTTxdGjVeBml";
        URL url = new URL(endpoint + "&client_id=" + client_id + "&client_secret=" + client_secret);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode + " - " + connection.getResponseMessage());
        }

        String contentType = connection.getContentType();
        if (contentType == null || !contentType.contains("application/json")) {
            throw new IOException("Tipo de conteúdo inesperado: " + contentType);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            if (response.length() == 0) {
                throw new IOException("A resposta da API está vazia.");
            }

            System.out.println("Resposta da API: " + response.toString());

            return response.toString();
        }
    }

}

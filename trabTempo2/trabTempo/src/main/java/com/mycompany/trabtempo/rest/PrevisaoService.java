/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.rest;

/**
 *
 * @author Julia
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrevisaoService extends ApiService {

    public JSONObject fetchPrevisaoOld(String cityId) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/forecast/locale/" + cityId + "/days/15";
        String response = makeRequest(endpoint);
        return new JSONObject(response);
    }

    public JSONObject fetchPrevisao(String cityName, String countryCode) throws Exception {
        String endpoint = String.format("https://data.api.xweather.com/forecasts/%s,%s?format=json&filter=day&limit=7", cityName, countryCode);
        String response = make2Request(endpoint);
        return new JSONObject(response);
    }

    private static final String API_URL = "https://api-free.deepl.com/v2/translate";
    private static final String AUTH_KEY = "e6edd28e-d179-4bc8-8a3d-9cca14f0259e:fx";

    public JSONObject translate(String text, String targetLang) throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "DeepL-Auth-Key " + AUTH_KEY);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("text", new JSONArray().put(text));
        jsonPayload.put("target_lang", targetLang);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode + " - " + connection.getResponseMessage());
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

            return new JSONObject(response.toString());
        }
    }
}

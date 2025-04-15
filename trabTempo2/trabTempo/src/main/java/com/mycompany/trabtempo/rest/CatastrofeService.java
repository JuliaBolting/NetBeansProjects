/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabtempo.rest;

/**
 *
 * @author Julia
 */
import org.json.JSONArray;
import org.json.JSONObject;

public class CatastrofeService extends ApiService {

    public JSONObject fetchFloodRisk(double latitude, double longitude) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/flood/risk?latitude=" + latitude + "&longitude=" + longitude;
        String response = makeRequest(endpoint);
        return new JSONObject(response);
    }

    public JSONArray fetchLightningStrikes(double latitude, double longitude) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/lightning/strikes?from=2024-08-01&to=2024-08-01&latitude=" + latitude + "&longitude=" + longitude + "&radius=1000";
        String response = makeRequest(endpoint);
        return new JSONArray(response);
    }

    public JSONObject fetchMosquitoIndex(String cityId) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/index/mosquito/locale/" + cityId + "/days/5";
        String response = makeRequest(endpoint);
        return new JSONObject(response);
    }

    public JSONArray fetchRespiratoryDiseaseIndex(String cityId) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/index/respiratory-disease/locale/" + cityId;
        String response = makeRequest(endpoint);
        return new JSONArray(response);
    }

    public JSONArray fetchAlerts() throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/monitoring/alerts";
        String response = makeRequest(endpoint);
        JSONObject jsonResponse = new JSONObject(response);
        return jsonResponse.getJSONObject("monitoring").getJSONArray("alerts");
    }
}

package com.mycompany.trabtempo.rest;

import data.CidadeDataLoader;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class CidadeServer extends ApiService implements CidadeDataLoader {

    @Override
    public JSONArray fetchCidades(String estado) throws Exception {
        String endpoint = "http://apiadvisor.climatempo.com.br/api/v1/locale/city?state=" + estado + "&country=BR";
        System.out.println("URL da API: " + endpoint);
        try {
            String response = makeRequest(endpoint);
            return new JSONArray(response);
        } catch (IOException e) {
            throw new Exception("Erro ao fazer a solicitação para a API de cidades", e);
        } catch (JSONException e) {
            throw new Exception("Erro ao processar a resposta da API de cidades", e);
        }
    }
}

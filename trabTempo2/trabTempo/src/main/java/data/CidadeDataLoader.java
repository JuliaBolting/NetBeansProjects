/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import org.json.JSONArray;

public interface CidadeDataLoader {
    JSONArray fetchCidades(String stateAbbr) throws Exception;
}


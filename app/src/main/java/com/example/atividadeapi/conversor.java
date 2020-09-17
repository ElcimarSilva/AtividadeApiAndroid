package com.example.atividadeapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class conversor {
    public pessoa getInformacao(String end){
        String json = conexao.getJsonFromApi(end);
        pessoa retorno = parseJson(json);
        return retorno;
    }

    private pessoa parseJson(String json){
        try {
            pessoa pessoa = new pessoa();

            JSONObject jsonObj = new JSONObject(json);
            pessoa.setUrl(jsonObj.getString("html_url"));
            pessoa.setId(jsonObj.getString("id"));
            pessoa.setLogin(jsonObj.getString("login"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
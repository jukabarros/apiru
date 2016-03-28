package br.api.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.api.model.Prato;


public class JsonParser {
	
	public Prato jsonToPrato(String json) throws ParseException{
		Prato p = new Prato();
		JSONObject jsonObj = new JSONObject(json);
		
		p.setCodigo(jsonObj.getInt("codigo"));
		p.setDescricao(jsonObj.getString("descricao"));
		p.setLivreGlicose(jsonObj.getBoolean("livreGlicose"));
		p.setLivreGluten(jsonObj.getBoolean("livreGluten"));
		p.setLivreLactose(jsonObj.getBoolean("livreLactose"));
		p.setQuantidadeKcal(jsonObj.getDouble("quantidadeKcal"));
		p.setTipoPrato(jsonObj.getString("tipoPrato"));
		
		List<String> listSemanas = new ArrayList<String>();
		JSONArray array = jsonObj.getJSONArray("diasSemana");
		for (int i = 0; i < array.length(); i++) {
			listSemanas.add(array.getJSONObject(i).getString("dia"));
		}
		
		p.setDiasSemana(listSemanas);
		
		return p;
	}

}

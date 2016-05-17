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
		
		JSONArray array = jsonObj.getJSONArray("diasSemana");
		List<String> diasSemana = new ArrayList<String>();
		for (int i = 0; i < array.length(); i++) {
			diasSemana.add(array.getString(i));
		}
		
		p.setDiasSemana(diasSemana);
		
		return p;
	}

}

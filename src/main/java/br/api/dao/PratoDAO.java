package br.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.api.model.Prato;

@Repository("pratoDAO")
public class PratoDAO {
	
	private List<Prato> listaPratos = new ArrayList<Prato>();
	
	public void addPrato(Prato p){
		listaPratos.add(p);
	}
	
	public Prato getByCodigo(Integer codigo){
		for (int i = 0; i < listaPratos.size(); i++) {
			Prato prato = this.listaPratos.get(i);
			if (codigo == prato.getCodigo())
				return prato;
		}
		return null;
	}
	
	public void deletePrato (Prato p){
		this.listaPratos.remove(p);
	}
	
	public List<Prato> getListaPratos() {
		return listaPratos;
	}

	public void setListaPratos(List<Prato> listaPratos) {
		this.listaPratos = listaPratos;
	}
	
	
}

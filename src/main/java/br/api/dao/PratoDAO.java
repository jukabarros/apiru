package br.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.api.model.Prato;

@Repository("pratoDAO")
public class PratoDAO {
	
	private List<Prato> listaPratos = new ArrayList<Prato>();
	
	/**
	 * Cadastra novo prato
	 * @param p prato
	 */
	public void addPrato(Prato p){
		listaPratos.add(p);
	}
	
	/**
	 * Consulta o prato pelo codigo
	 * @param codigo chave da consulta
	 * @return
	 */
	public Prato getByCodigo(Integer codigo){
		for (int i = 0; i < listaPratos.size(); i++) {
			Prato prato = this.listaPratos.get(i);
			if (codigo == prato.getCodigo()){
				return prato;
			}
		}
		return null;
	}
	
	/**
	 * Deleta um prato
	 * @param p
	 */
	public void deletePrato(Prato p){
		this.listaPratos.remove(p);
	}
	
	
	// GET AND SET
	public List<Prato> getListaPratos() {
		return listaPratos;
	}

	public void setListaPratos(List<Prato> listaPratos) {
		this.listaPratos = listaPratos;
	}
	
	
}

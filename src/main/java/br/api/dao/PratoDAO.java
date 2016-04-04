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
	 * Retorna uma lista de prato de acordo com os dias da semana passados
	 * como parametros
	 * @param diasSemana
	 * @return
	 */
	public List<Prato> getByDiaSemana(List<String> diasSemana){
		List<Prato> pratosFiltrados = new ArrayList<Prato>();
		for (Prato prato : listaPratos) {
			
			for (int i = 0; i < diasSemana.size(); i++) {
				String diaSemanaPrato = diasSemana.get(i);
				if (prato.getDiasSemana().contains(diaSemanaPrato)){
					pratosFiltrados.add(prato);
					break;
					
				}
			}
		}
		return pratosFiltrados;
	}
	
	/**
	 * Atualiza um prato
	 * @param p prato
	 */
	public void updatePrato(Prato p){
		for (int i = 0; i < this.listaPratos.size(); i++) {
			if (this.listaPratos.get(i).getCodigo() == p.getCodigo()) {
				this.listaPratos.get(i).setDescricao(p.getDescricao());
				this.listaPratos.get(i).setDiasSemana(p.getDiasSemana());
				this.listaPratos.get(i).setLivreGlicose(p.isLivreGlicose());
				this.listaPratos.get(i).setLivreGluten(p.isLivreGluten());
				this.listaPratos.get(i).setLivreLactose(p.isLivreLactose());
				this.listaPratos.get(i).setQuantidadeKcal(p.getQuantidadeKcal());
				this.listaPratos.get(i).setTipoPrato(p.getTipoPrato());
				break;
			}
		}
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

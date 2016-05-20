package br.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
		for (int i = 0; i < getListaPratos().size(); i++) {
			Prato prato = getListaPratos().get(i);
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
		for (Prato prato : getListaPratos()) {
			
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
		for (int i = 0; i < getListaPratos().size(); i++) {
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
		getListaPratos().remove(p);
	}
	
	private void insertInitPratos(){
		Prato p1 = new Prato();
		p1.setCodigo(1);
		p1.setDescricao("Feijoada");
		p1.setLivreGlicose(true);
		p1.setLivreGluten(false);
		p1.setLivreLactose(true);
		p1.setQuantidadeKcal(900.45);
		p1.setTipoPrato("Almoço");
		p1.setDiasSemana(Arrays.asList("Segunda-Feira", "Quarta-Feira"));
		
		Prato p2 = new Prato();
		p2.setCodigo(2);
		p2.setDescricao("Buchada de Bode");
		p2.setLivreGlicose(false);
		p2.setLivreGluten(false);
		p2.setLivreLactose(true);
		p2.setQuantidadeKcal(892.66);
		p2.setTipoPrato("Café da Manhã");
		p2.setDiasSemana(Arrays.asList("Terça-Feira", "Quarta-Feira"));
		
		Prato p3 = new Prato();
		p3.setCodigo(3);
		p3.setDescricao("Angu com Leite");
		p3.setLivreGlicose(false);
		p3.setLivreGluten(true);
		p3.setLivreLactose(false);
		p3.setQuantidadeKcal(632.22);
		p3.setTipoPrato("Janta");
		p3.setDiasSemana(Arrays.asList("Terça-Feira", "Quinta-Feira"));
		
		Prato p4 = new Prato();
		p4.setCodigo(4);
		p4.setDescricao("Sarapatel");
		p4.setLivreGlicose(true);
		p4.setLivreGluten(false);
		p4.setLivreLactose(true);
		p4.setQuantidadeKcal(850.00);
		p4.setTipoPrato("Almoço");
		p4.setDiasSemana(Arrays.asList("Quarta-Feira", "Sexta-Feira"));
		
		this.listaPratos.add(p1);
		this.listaPratos.add(p2);
		this.listaPratos.add(p3);
		this.listaPratos.add(p4);

	}
	
	// GET AND SET
	public List<Prato> getListaPratos() {
		if (this.listaPratos.isEmpty()){
			this.insertInitPratos();
		}
		return listaPratos;
	}

	public void setListaPratos(List<Prato> listaPratos) {
		this.listaPratos = listaPratos;
	}
	
	
}

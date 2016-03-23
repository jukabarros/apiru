package br.api.model;

import java.util.List;

public class Prato {
	
	private Integer codigo;
	
	private String descricao;
	
	private List<String> diasSemana;
	
	private double quantidadeKcal;
	
	private boolean livreGluten;
	
	private boolean livreLactose;
	
	private boolean livreGlicose;
	
	private String tipoPrato;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<String> diasSemana) {
		this.diasSemana = diasSemana;
	}

	public double getQuantidadeKcal() {
		return quantidadeKcal;
	}

	public void setQuantidadeKcal(double quantidadeKcal) {
		this.quantidadeKcal = quantidadeKcal;
	}

	public boolean isLivreGluten() {
		return livreGluten;
	}

	public void setLivreGluten(boolean livreGluten) {
		this.livreGluten = livreGluten;
	}

	public boolean isLivreLactose() {
		return livreLactose;
	}

	public void setLivreLactose(boolean livreLactose) {
		this.livreLactose = livreLactose;
	}

	public boolean isLivreGlicose() {
		return livreGlicose;
	}

	public void setLivreGlicose(boolean livreGlicose) {
		this.livreGlicose = livreGlicose;
	}

	public String getTipoPrato() {
		return tipoPrato;
	}

	public void setTipoPrato(String tipoPrato) {
		this.tipoPrato = tipoPrato;
	}

	@Override
	public String toString() {
		return "Prato [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	

}

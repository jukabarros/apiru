package org.gradle;

public class Estudante {
	
	private int id;
	private String nome;
	private String curso;
		
	public Estudante(int id, String nome, String curso){
		this.id = id;
		this.nome = nome;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String toString() {
		return "Estudante id: " + getId() + " \nNome: " + getNome() + " \nCurso: " + getCurso();
	}
}

package org.gradle;

public class Estudante {
	
	private String curso;
	private int ano;
		
	public Estudante(String estCurso, int estAno){
		curso = estCurso;
		ano = estAno;		
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Estudante do curso: " + getCurso() + " ano: " + getAno();
	}
}

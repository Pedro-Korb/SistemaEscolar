package com.classes.DTO;
import java.util.ArrayList;

public class Disciplina {
	
	private int id_disciplina;
	private String nome_disciplina;
	private ArrayList<Professor> professor_disciplina;
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nome_disciplina) {
		super();
		this.nome_disciplina = nome_disciplina;
	}

	public Disciplina(int id_disciplina, String nome_disciplina) {
		super();
		this.id_disciplina = id_disciplina;
		this.nome_disciplina = nome_disciplina;
	}
	
	public Disciplina(int id_disciplina, String nome_disciplina, ArrayList<Professor> professor_disciplina) {
		super();
		this.id_disciplina = id_disciplina;
		this.nome_disciplina = nome_disciplina;
		this.professor_disciplina = professor_disciplina;
	}

	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public String getNome_disciplina() {
		return nome_disciplina;
	}
	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}
	public ArrayList<Professor> getProfessor_disciplina() {
		return professor_disciplina;
	}
	public void setProfessor_disciplina(ArrayList<Professor> professor_disciplina) {
		this.professor_disciplina = professor_disciplina;
	}
	
	public void adicionarProfessor(Professor professor) {
	    if (professor_disciplina == null) {
	        professor_disciplina = new ArrayList<Professor>();
	    }
	    
	    if (!professor_disciplina.contains(professor)) {
	        professor_disciplina.add(professor);
	    }
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Disciplina [id_disciplina=");
		builder.append(id_disciplina);
		builder.append(", nome_disciplina=");
		builder.append(nome_disciplina);
		builder.append(", professor_disciplina=");
		builder.append(professor_disciplina);
		builder.append("]");
		return builder.toString();
	}
}

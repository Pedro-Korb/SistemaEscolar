package com.classes.DTO;

import java.util.ArrayList;

public class Curso {
	
	private int id_curso;
	private String nome_curso;
	private ArrayList<Fase> fases_curso;
	
	public Curso() {
		super();
	}
	
	
	
	public Curso(int id_curso, String nome_curso) {
		super();
		this.id_curso = id_curso;
		this.nome_curso = nome_curso;
	}



	public Curso(String nome_curso) {
		super();
		this.nome_curso = nome_curso;
	}
	public Curso(String nome_curso, ArrayList<Fase> fases_curso) {
		super();
		this.nome_curso = nome_curso;
		this.fases_curso = fases_curso;
	}
	public Curso(int id_curso, String nome_curso, ArrayList<Fase> fases_curso) {
		super();
		this.id_curso = id_curso;
		this.nome_curso = nome_curso;
		this.fases_curso = fases_curso;
	}
	
	
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public String getNome_curso() {
		return nome_curso;
	}
	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
	public ArrayList<Fase> getFases_curso() {
		return fases_curso;
	}
	public void setFases_curso(ArrayList<Fase> fases_curso) {
		this.fases_curso = fases_curso;
	}
	
	public void adicionarFase (Fase fase) {
	    if (fases_curso == null) {
	    	fases_curso = new ArrayList<>();
	    }
	    
	    if (!fases_curso.contains(fase)) {
	    	fases_curso.add(fase);
	    }
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [id_curso=");
		builder.append(id_curso);
		builder.append(", nome_curso=");
		builder.append(nome_curso);
		builder.append(", fases_curso=");
		builder.append(fases_curso);
		builder.append("]");
		return builder.toString();
	}
}

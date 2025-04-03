package com.classes.DTO;

import java.util.ArrayList;

public class Fase {
	
	private int id_fase;
	private int numero_fase;
	private ArrayList<Disciplina> disciplinas_fase;
	
	public Fase() {
		super();
	}

	public Fase(int numero_fase) {
		super();
		this.numero_fase = numero_fase;
	}
	
	
	public Fase(int numero_fase, ArrayList<Disciplina> disciplinas_fase) {
		super();
		this.numero_fase = numero_fase;
		this.disciplinas_fase = disciplinas_fase;
	}

	public Fase(int id_fase, int numero_fase, ArrayList<Disciplina> disciplinas_fase) {
		super();
		this.id_fase = id_fase;
		this.numero_fase = numero_fase;
		this.disciplinas_fase = disciplinas_fase;
	}


	public int getId_fase() {
		return id_fase;
	}
	public void setId_fase(int id_fase) {
		this.id_fase = id_fase;
	}
	public int getNumero_fase() {
		return numero_fase;
	}
	public void setNumero_fase(int numero_fase) {
		this.numero_fase = numero_fase;
	}
	public ArrayList<Disciplina> getDisciplinas_fase() {
		return disciplinas_fase;
	}
	public void setDisciplinas_fase(ArrayList<Disciplina> disciplinas_fase) {
		this.disciplinas_fase = disciplinas_fase;
	}
	
	public void adicionarDisciplina(Disciplina disc) {
	    if (disciplinas_fase == null) {
	    	disciplinas_fase = new ArrayList<>();
	    }
	    
	    if (!disciplinas_fase.contains(disc)) {
	    	disciplinas_fase.add(disc);
	    }
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fase [id_fase=");
		builder.append(id_fase);
		builder.append(", numero_fase=");
		builder.append(numero_fase);
		builder.append(", disciplinas_fase=");
		builder.append(disciplinas_fase);
		builder.append("]");
		return builder.toString();
	}
}

package com.classes.DTO;

import java.util.ArrayList;

public class Aluno {
	
	
	private int id_aluno;
	private String nome_aluno;
	protected Curso curso;
	protected ArrayList<DisciplinaCurso> disciplinas_relacionadas;
	
	public Aluno() {
		super();
	}
	
	
	public Aluno(Curso curso, String nome_aluno) {
		super();
		this.curso = curso;
		this.nome_aluno = nome_aluno;
	}


	public Aluno(String nome_aluno, Curso curso, ArrayList<DisciplinaCurso> disciplinas_relacionadas) {
		super();
		this.nome_aluno = nome_aluno;
		this.curso = curso;
		this.disciplinas_relacionadas = disciplinas_relacionadas;
	}
	public Aluno(int id_aluno, String nome_aluno, Curso curso, ArrayList<DisciplinaCurso> disciplinas_relacionadas) {
		super();
		this.id_aluno = id_aluno;
		this.nome_aluno = nome_aluno;
		this.curso = curso;
		this.disciplinas_relacionadas = disciplinas_relacionadas;
	}
	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public ArrayList<DisciplinaCurso> getDisciplinas_relacionadas() {
		return disciplinas_relacionadas;
	}
	public void setDisciplinas_relacionadas(ArrayList<DisciplinaCurso> disciplinas_relacionadas) {
		this.disciplinas_relacionadas = disciplinas_relacionadas;
	}
	
	public void adicionarDisciplinasRelacionadas(DisciplinaCurso disciplinaCurso) {
	    if (disciplinas_relacionadas == null) {
	    	disciplinas_relacionadas = new ArrayList<>();
	    }
	    
	    if (!disciplinas_relacionadas.contains(disciplinaCurso)) {
	    	disciplinas_relacionadas.add(disciplinaCurso);
	    }
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [id_aluno=");
		builder.append(id_aluno);
		builder.append(", nome_aluno=");
		builder.append(nome_aluno);
		builder.append(", curso=");
		builder.append(curso);
		builder.append(", disciplinas_relacionadas=");
		builder.append(disciplinas_relacionadas);
		builder.append("]");
		return builder.toString();
	}
}

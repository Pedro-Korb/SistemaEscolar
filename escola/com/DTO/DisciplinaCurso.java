package com.classes.DTO;

import java.util.ArrayList;

public class DisciplinaCurso {
	private int id_disciplina_curso;
	private Disciplina disciplina;
	private String situacao;
	private String ano_semestre;
	protected ArrayList<RegistroAcademico> registro_academico;
	protected ArrayList<Avaliacao> avaliacoes;
	
	
	
	public DisciplinaCurso() {
		super();
	}
	
	
	
	public DisciplinaCurso(Disciplina disciplina, String situacao, String ano_semestre) {
		super();
		this.disciplina = disciplina;
		this.situacao = situacao;
		this.ano_semestre = ano_semestre;
	}



	public DisciplinaCurso(Disciplina disciplina, String situacao, String ano_semestre,
			ArrayList<RegistroAcademico> registro_academico, ArrayList<Avaliacao> avaliacoes) {
		super();
		this.disciplina = disciplina;
		this.situacao = situacao;
		this.ano_semestre = ano_semestre;
		this.registro_academico = registro_academico;
		this.avaliacoes = avaliacoes;
	}
	public DisciplinaCurso(int id_disciplina_curso, Disciplina disciplina, String situacao, String ano_semestre,
			ArrayList<RegistroAcademico> registro_academico, ArrayList<Avaliacao> avaliacoes) {
		super();
		this.id_disciplina_curso = id_disciplina_curso;
		this.disciplina = disciplina;
		this.situacao = situacao;
		this.ano_semestre = ano_semestre;
		this.registro_academico = registro_academico;
		this.avaliacoes = avaliacoes;
	}
	public int getId_disciplina_curso() {
		return id_disciplina_curso;
	}
	public void setId_disciplina_curso(int id_disciplina_curso) {
		this.id_disciplina_curso = id_disciplina_curso;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getAno_semestre() {
		return ano_semestre;
	}
	public void setAno_semestre(String ano_semestre) {
		this.ano_semestre = ano_semestre;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public ArrayList<RegistroAcademico> getRegistro_academico() {
		return registro_academico;
	}
	public void setRegistro_academico(ArrayList<RegistroAcademico> registro_academico) {
		this.registro_academico = registro_academico;
	}
	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public void adicionarRegistroAcademico(RegistroAcademico registroAcademico) {
	    if (registro_academico == null) {
	    	registro_academico = new ArrayList<>();
	    }
	    
	    if (!registro_academico.contains(registroAcademico)) {
	    	registro_academico.add(registroAcademico);
	    }
	}
	
	public void adicionarAvalicao(Avaliacao avaliacao) {
	    if (avaliacoes == null) {
	    	avaliacoes = new ArrayList<>();
	    }
	    
	    if (!avaliacoes.contains(avaliacao)) {
	    	avaliacoes.add(avaliacao);
	    }
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DisciplinaCurso [id_disciplina_curso=");
		builder.append(id_disciplina_curso);
		builder.append(", situacao=");
		builder.append(situacao);
		builder.append(", ano_semestre=");
		builder.append(ano_semestre);
		builder.append(", disciplina=");
		builder.append(disciplina);
		builder.append(", registro_academico=");
		builder.append(registro_academico);
		builder.append(", avaliacoes=");
		builder.append(avaliacoes);
		builder.append("]");
		return builder.toString();
	}
}

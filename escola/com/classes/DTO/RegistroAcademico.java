package com.classes.DTO;

public class RegistroAcademico {
	private int id_registro_academico;
	private String data_registro_academico;
	private int numero_aulas;
	protected Professor professor;
	protected PresencaAluno presenca_aluno;
	
	public RegistroAcademico() {
		super();
	}
	
	public RegistroAcademico(PresencaAluno presenca_aluno, String data_registro_academico, int numero_aulas, Professor professor) {
		super();
		this.presenca_aluno = presenca_aluno;
		this.data_registro_academico = data_registro_academico;
		this.numero_aulas = numero_aulas;
		this.professor = professor;
	}
	public RegistroAcademico(int id_registro_academico, String data_registro_academico, int numero_aulas, Professor professor, PresencaAluno presenca_aluno) {
		super();
		this.id_registro_academico = id_registro_academico;
		this.data_registro_academico = data_registro_academico;
		this.numero_aulas = numero_aulas;
		this.professor = professor;
		this.presenca_aluno = presenca_aluno;
	}
	
	
	public int getId_registro_academico() {
		return id_registro_academico;
	}
	public void setId_registro_academico(int id_registro_academico) {
		this.id_registro_academico = id_registro_academico;
	}
	public String getData_registro_academico() {
		return data_registro_academico;
	}
	public void setData_registro_academico(String data_registro_academico) {
		this.data_registro_academico = data_registro_academico;
	}
	public int getNumero_aulas() {
		return numero_aulas;
	}
	public void setNumero_aulas(int numero_aulas) {
		this.numero_aulas = numero_aulas;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public PresencaAluno getPresenca_aluno() {
		return presenca_aluno;
	}
	public void setPresenca_aluno(PresencaAluno presenca_aluno) {
		this.presenca_aluno = presenca_aluno;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistroAcademico [id_registro_academico=");
		builder.append(id_registro_academico);
		builder.append(", data_registro_academico=");
		builder.append(data_registro_academico);
		builder.append(", numero_aulas=");
		builder.append(numero_aulas);
		builder.append(", professor=");
		builder.append(professor);
		builder.append(", presenca_aluno=");
		builder.append(presenca_aluno);
		builder.append("]");
		return builder.toString();
	}
}

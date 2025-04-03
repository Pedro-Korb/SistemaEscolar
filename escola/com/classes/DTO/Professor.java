package com.classes.DTO;

public class Professor {
	
	private int id_professor;
	private String nome_professor;
	private String especialidade_professor;
	
	public Professor() {
		
	}
	
	public Professor(String nome_professor, String especialidade_professor) {
		this.nome_professor = nome_professor;
		this.especialidade_professor = especialidade_professor;
	}
	
	public Professor(int id_professor, String nome_professor, String especialidade_professor) {		
		this.id_professor = id_professor;
		this.nome_professor = nome_professor;
		this.especialidade_professor = especialidade_professor;
	}

	public int getId_professor() {
		return id_professor;
	}
	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}
	public String getNome_professor() {
		return nome_professor;
	}
	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}
	public String getEspecialidade_professor() {
		return especialidade_professor;
	}
	public void setEspecialidade_professor(String especialidade_professor) {
		this.especialidade_professor = especialidade_professor;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Professor [id_professor=");
		builder.append(id_professor);
		builder.append(", nome_professor=");
		builder.append(nome_professor);
		builder.append(", especialidade_professor=");
		builder.append(especialidade_professor);
		builder.append("]");
		return builder.toString();
	}
}

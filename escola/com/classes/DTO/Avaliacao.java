package com.classes.DTO;

public class Avaliacao {
	
	private int id_avaliacao;
	protected RegistroAvaliacao registro_avaliacao;
	private String data_avaliacao;
	private int numeracao_avaliacao;
	protected Professor professor;
	
	public Avaliacao() {
		super();
	}
	
	public Avaliacao(RegistroAvaliacao registro_avaliacao, String data_avaliacao, int numeracao_avaliacao,
			Professor professor) {
		super();
		this.registro_avaliacao = registro_avaliacao;
		this.data_avaliacao = data_avaliacao;
		this.numeracao_avaliacao = numeracao_avaliacao;
		this.professor = professor;
	}
	public Avaliacao(int id_avaliacao, RegistroAvaliacao registro_avaliacao, String data_avaliacao,
			int numeracao_avaliacao, Professor professor) {
		super();
		this.id_avaliacao = id_avaliacao;
		this.registro_avaliacao = registro_avaliacao;
		this.data_avaliacao = data_avaliacao;
		this.numeracao_avaliacao = numeracao_avaliacao;
		this.professor = professor;
	}
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public int getNumeracao_avaliacao() {
		return numeracao_avaliacao;
	}
	public void setNumeracao_avaliacao(int numeracao_avaliacao) {
		this.numeracao_avaliacao = numeracao_avaliacao;
	}
	public String getData_avaliacao() {
		return data_avaliacao;
	}
	public void setData_avaliacao(String data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public RegistroAvaliacao getRegistro_avaliacao() {
		return registro_avaliacao;
	}
	public void setRegistro_avaliacao(RegistroAvaliacao registro_avaliacao) {
		this.registro_avaliacao = registro_avaliacao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avaliacao [id_avaliacao=");
		builder.append(id_avaliacao);
		builder.append(", numeracao_avaliacao=");
		builder.append(numeracao_avaliacao);
		builder.append(", data_avaliacao=");
		builder.append(data_avaliacao);
		builder.append(", professor=");
		builder.append(professor);
		builder.append(", registro_avaliacao=");
		builder.append(registro_avaliacao);
		builder.append("]");
		return builder.toString();
	}
}

package com.classes.DTO;

public class RegistroAvaliacao {
	
	private int id_registro_avaliacao;
	private double nota_aluno;
	protected Aluno aluno;
	
	public RegistroAvaliacao() {
		super();
	}
	public RegistroAvaliacao(Aluno aluno, double nota_aluno) {
		super();
		this.aluno = aluno;
		this.nota_aluno = nota_aluno;
	}
	public RegistroAvaliacao(int id_registro_avaliacao, double nota_aluno, Aluno aluno) {
		super();
		this.id_registro_avaliacao = id_registro_avaliacao;
		this.nota_aluno = nota_aluno;
		this.aluno = aluno;
	}
	public int getId_registro_avaliacao() {
		return id_registro_avaliacao;
	}
	public void setId_registro_avaliacao(int id_registro_avaliacao) {
		this.id_registro_avaliacao = id_registro_avaliacao;
	}
	public double getNota_aluno() {
		return nota_aluno;
	}
	public void setNota_aluno(double nota_aluno) {
		this.nota_aluno = nota_aluno;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistroAvaliacao [id_registro_avaliacao=");
		builder.append(id_registro_avaliacao);
		builder.append(", nota_aluno=");
		builder.append(nota_aluno);
		builder.append(", aluno=");
		builder.append(aluno);
		builder.append("]");
		return builder.toString();
	}
}

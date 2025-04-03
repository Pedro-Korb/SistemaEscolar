package com.classes.DTO;


public class PresencaAluno {
	private int id_presenca_aluno;
	private int numero_presencas;
	protected Aluno aluno;
	
	public PresencaAluno() {
		super();
	}

	public PresencaAluno(int numero_presencas, Aluno aluno) {
		super();
		this.numero_presencas = numero_presencas;
		this.aluno = aluno;
	}


	public PresencaAluno(int id_presenca_aluno, int numero_presencas, Aluno aluno) {
		super();
		this.id_presenca_aluno = id_presenca_aluno;
		this.numero_presencas = numero_presencas;
		this.aluno = aluno;
	}
	
	
	public int getNumero_presencas() {
		return numero_presencas;
	}
	public void setNumero_presencas(int numero_presencas) {
		this.numero_presencas = numero_presencas;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public int getId_presenca_aluno() {
		return id_presenca_aluno;
	}
	public void setId_presenca_aluno(int id_presenca_aluno) {
		this.id_presenca_aluno = id_presenca_aluno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PresencaAluno [id_presenca_aluno=");
		builder.append(id_presenca_aluno);
		builder.append(", numero_presencas=");
		builder.append(numero_presencas);
		builder.append(", aluno=");
		builder.append(aluno);
		builder.append("]");
		return builder.toString();
	}
}

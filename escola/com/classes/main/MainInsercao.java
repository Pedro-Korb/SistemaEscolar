package com.classes.main;

import com.classes.BO.AlunoBO;
import com.classes.BO.AvaliacaoBO;
import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaCursoBO;
import com.classes.BO.FaseBO;
import com.classes.BO.PresencaAlunoBO;
import com.classes.BO.ProfessorBO;
import com.classes.BO.RegistroAcademicoBO;
import com.classes.BO.RegistroAvaliacaoBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Avaliacao;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaCurso;
import com.classes.DTO.Fase;
import com.classes.DTO.PresencaAluno;
import com.classes.DTO.Professor;
import com.classes.DTO.RegistroAcademico;
import com.classes.DTO.RegistroAvaliacao;

public class MainInsercao {
	public static void main(String[] args) {
//		
//		/**
//		 * Inserção de professor
//		 */
//		ProfessorBO profbo = new ProfessorBO();
//		Professor prof = new Professor("Rodrigo Curvello", "Programação");
//		if (profbo.inserir(prof))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		/**
//		 * Inserção de disciplina
//		 */
//		DisciplinaBO discbo = new DisciplinaBO();
//		Disciplina disci = new Disciplina("Sistemas Operacionais");
//		
//		if (discbo.inserirDisciplina(disci))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		
//		/**
//		 * Inserção de professor da disciplina
//		 */
//		if (discbo.inserirProfessorDisciplina(4, 11))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		
//		/**
//		 * Inserção de fase
//		 */
//		FaseBO fasebo = new FaseBO();
//		Fase fase = new Fase(5);
//		
//		if (fasebo.inserirFase(fase))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		/**
//		 * Inserção de disciplina da fase
//		 */
//		if (fasebo.inserirDisciplinaFase(5, 5))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");		
//		
//		
//		
//		/**
//		 * Inserção de Curso
//		 */
//		CursoBO cursobo= new CursoBO();
//		Curso curso = new Curso("Matemática");
//		
//		if (cursobo.inserirCurso(curso))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		/**
//		 * Inserção de fases do curso
//		 */
//		if (cursobo.inserirFaseCurso(4, 4))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");		
//		
//		
//		
//		/**
//		 * Inserção de Presenca Aluno TESTAR TESTAR
//		 */
//		PresencaAlunoBO presalbo = new PresencaAlunoBO();
//		Aluno al = new Aluno();
//		PresencaAluno presal = new PresencaAluno(5, al);
//		
//		if (presalbo.inserirPresencaAluno(presal))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		/**
//		 * Inserção de Registro Academico TESTAR TESTAR
//		 */
//		RegistroAcademicoBO regacadbo = new RegistroAcademicoBO();
//		Aluno aluno = new Aluno();
//		PresencaAluno presal = new PresencaAluno(5, aluno);
//		Professor prof = new Professor("Marcio Nunes", "Arquitetura de Softaware");
//		RegistroAcademico regacad = new RegistroAcademico(presal, "10/02/2025", 5, prof);
//		
//		if (regacadbo.inserirRegistroAcademico(regacad))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		/**
//		 * Inserção de Registro avaliacao TESTAR TESTAR
//		 */
//		Aluno alu2 = new Aluno();
//		RegistroAvaliacaoBO regavbo = new RegistroAvaliacaoBO();
//		RegistroAvaliacao regav = new RegistroAvaliacao(alu2, 5.5);
//		
//		if (regavbo.inserirRegistroAvaliacao(regav))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		/**
//		 * Inserção de Avaliacao TESTAR TESTAR
//		 */
//		Professor prof2 = new Professor();
//		Aluno alu3 = new Aluno();
//		RegistroAvaliacao regav = new RegistroAvaliacao(alu3, 5.5);
//		AvaliacaoBO avabo = new AvaliacaoBO();
//		Avaliacao ava = new Avaliacao(regav, "20/04/2025", 3, prof2);
//		
//		if (avabo.inserirAvaliacao(ava))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		/**
//		 * Inserção de Disciplina Curso TESTAR TESTAR
//		 */
//		DisciplinaCursoBO discicursobo = new DisciplinaCursoBO();
//		Disciplina disciTeste = new Disciplina(11, "Sistemas Operacionais");
//		DisciplinaCurso discicurso = new DisciplinaCurso(disciTeste, "Matriculado", "2025/02");
//		
//		if (discicursobo.inserirDisciplinaCurso(discicurso))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		/**
//		 * Inserção de Registro Academico Disciplina Curso TESTAR TESTAR
//		 */
//		DisciplinaCursoBO discicursobo2 = new DisciplinaCursoBO();
//		
//		if (discicursobo2.inserirRegistroAcademicoDisciplinaCurso(2, 3))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		/**
//		 * Inserção de Avaliacao Disciplina Curso TESTAR TESTAR
//		 */
//		DisciplinaCursoBO discicursobo3 = new DisciplinaCursoBO();
//		
//		if (discicursobo3.inserirAvaliacaoDisciplinaCurso(2, 3))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		/**
//		 * Inserção de Aluno TESTAR TESTAR
//		 */
//		AlunoBO alunobo = new AlunoBO();
//		Curso curso = new Curso(4, "Matemática");
//		Aluno al = new Aluno(curso, "João Carlos");
//		
//		if (alunobo.inserirAluno(al))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		/**
//		 * Inserção de Disciplinas relacionadas TESTAR TESTAR
//		 */
//		AlunoBO alunobo = new AlunoBO();
//		
//		if (alunobo.inserirDisciplinaCursoAluno(2, 1))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//		
//		
//		
//		DisciplinaBO discbo = new DisciplinaBO();
//		Disciplina disci = new Disciplina("Direito Constitucional");
//		if (discbo.inserirDisciplina(disci))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//	
//		
//		FaseBO fasebo = new FaseBO();
//		Fase fase1 = new Fase(1);
//		if (fasebo.inserirFase(fase1))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//
//		
//		/**
//		 * Inserção de disciplina da fase
//		 */
//		if (fasebo.inserirDisciplinaFase(1, 1))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");	
		
		
		/**
		 * Inserção de disciplina
		 */
		System.err.println("inserção de disciplinas");
		DisciplinaBO discbo = new DisciplinaBO();
		Disciplina disci = new Disciplina("Direito Constitucional");
		if (discbo.inserirDisciplina(disci))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Disciplina disci1 = new Disciplina("Direito Civil");
		if (discbo.inserirDisciplina(disci1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Disciplina disci2 = new Disciplina("Direito Penal");
		if (discbo.inserirDisciplina(disci2))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Disciplina disci3 = new Disciplina("Direito Administrativo");
		if (discbo.inserirDisciplina(disci3))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Disciplina disci4 = new Disciplina("Direito do Trabalho");
		if (discbo.inserirDisciplina(disci4))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Disciplina disci5 = new Disciplina("Constituicao");
		if (discbo.inserirDisciplina(disci5))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		
		
		
		
		
		/**
		 * Inserção de fase
		 */
		System.err.println("\n\ninserção de fases");
		FaseBO fasebo = new FaseBO();
		Fase fase1 = new Fase(1);
		if (fasebo.inserirFase(fase1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Fase fase2 = new Fase(2);
		if (fasebo.inserirFase(fase2))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		Fase fase3 = new Fase(3);
		if (fasebo.inserirFase(fase3))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		
		
		/**
		 * Inserção de disciplina da fase
		 */
		System.err.println("\n\ninserção de disciplinas na fase");
		if (fasebo.inserirDisciplinaFase(1, 1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		if (fasebo.inserirDisciplinaFase(2, 1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		

		if (fasebo.inserirDisciplinaFase(3, 2))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		if (fasebo.inserirDisciplinaFase(4, 2))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		
		if (fasebo.inserirDisciplinaFase(5, 3))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		if (fasebo.inserirDisciplinaFase(6, 3))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		
		
		
		/**
		 * Inserção de Curso
		 */
		System.err.println("\n\ninserção de curso");
		CursoBO cursobo= new CursoBO();
		Curso curso = new Curso("Direito");
		
		if (cursobo.inserirCurso(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		
		
		
		/**
		 * Inserção de fases do curso
		 */
		System.err.println("\n\ninserção de fases no curso");
		if (cursobo.inserirFaseCurso(1, 1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
		if (cursobo.inserirFaseCurso(3, 1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		if (cursobo.inserirFaseCurso(2, 1))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");		
		
		
	}
}

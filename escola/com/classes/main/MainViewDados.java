package com.classes.main;

import java.util.Iterator;
import java.util.List;

import com.classes.BO.AlunoBO;
import com.classes.BO.AvaliacaoBO;
import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaCursoBO;
import com.classes.BO.PresencaAlunoBO;
import com.classes.BO.ProfessorBO;
import com.classes.BO.RegistroAcademicoBO;
import com.classes.BO.RegistroAvaliacaoBO;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaCurso;
import com.classes.DTO.PresencaAluno;
import com.classes.DTO.Professor;
import com.classes.DTO.RegistroAcademico;
import com.classes.DTO.RegistroAvaliacao;
import com.classes.DTO.Aluno;
import com.classes.DTO.Avaliacao;
import com.classes.DTO.Curso;

public class MainViewDados {
	
	public static void main(String[] args) {
//		ProfessorBO profbo = new ProfessorBO();
//		List<Professor> professores = profbo.pesquisarTodos();
//		
//		for (Professor professor : professores) {
//			System.out.println(professor.getNome_professor());
//		}
//		
//		
//		System.out.println("\n\n");
//		
		/**
		 * Mostrar dados das disciplinas (com objeto professores)
		 */
//		System.err.println("Disciplinas");
		DisciplinaBO discibo = new DisciplinaBO();
		List<Disciplina> disci = discibo.pesquisarTodos();
		for (Disciplina disciplina : disci) {
			System.out.println(disciplina.toString());
		}
		
		System.out.println("\n\n");
		
		/**
		 * Mostrar dados do curso (com objeto fases)
		 */
//		System.err.println("Cursos");
		CursoBO cursobo = new CursoBO();
		List<Curso> curso = cursobo.pesquisarTodos();
		
		for (Curso curs : curso) {
			System.out.println(curs.toString());
		}
		
		System.out.println("\n\n");
		
		/**
		 * Mostrar dados de presença aluno (com objeto aluno -> unico) TESTAR TESTAR
		 */
//		System.err.println("Presenca Aluno");
		PresencaAlunoBO presalbo = new PresencaAlunoBO();
		List<PresencaAluno> presal = presalbo.pesquisarTodos();
		
		for (PresencaAluno presencaAluno : presal) {
			System.out.println(presencaAluno.toString());
		}
		
		System.out.println("\n\n");
		
		/**
		 * Mostrar dados de Registro Academico (com objeto aluno -> unico) TESTAR TESTAR
		 */
//		System.err.println("Registro Academico");
		RegistroAcademicoBO regacad = new RegistroAcademicoBO();
		List<RegistroAcademico> regac = regacad.pesquisarTodos();
		
		for (RegistroAcademico registroAcademico : regac) {
			System.out.println(registroAcademico.toString());
		}
		
		System.out.println("\n\n");
		
		/**
		 * Mostrar dados de Registro de Avaliacao (com objeto aluno -> unico) TESTAR TESTAR
		 */
//		System.err.println("Registro de avaliação");
		RegistroAvaliacaoBO regavbo = new RegistroAvaliacaoBO();
		List<RegistroAvaliacao> regav = regavbo.pesquisarTodos();

		for (RegistroAvaliacao registroAvaliacao : regav) {
			System.out.println(registroAvaliacao.toString());
		}
		
		System.out.println("\n\n");
		
		/**
		 * Mostrar dados de Avaliacao TESTAR TESTAR
		 */
//		System.err.println("Avaliação");
		AvaliacaoBO avbo = new AvaliacaoBO();
		List<Avaliacao> aval = avbo.pesquisarTodos();
		
		for (Avaliacao avaliacao : aval) {
			System.out.println(avaliacao.toString());
		}
		
		/**
		 * Mostrar dados de Disciplina Curso
		 */
//		System.err.println("Disciplina Curso");
		DisciplinaCursoBO discicurbo = new DisciplinaCursoBO();
		List<DisciplinaCurso> discicur = discicurbo.pesquisarTodos();
		
		for (DisciplinaCurso disciplinaCurso : discicur) {
			System.out.println(disciplinaCurso.toString());
		}
		
		
		/**
		 * Mostrar dados de Aluno
		 */
//		System.err.println("Aluno");
		AlunoBO albo = new AlunoBO();
		List<Aluno> alunos = albo.pesquisarTodos();
		
		for (Aluno aluno : alunos) {
			System.out.println(aluno.toString());
		}
		
		
		
	}
}

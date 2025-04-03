package com.classes.main;

import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class PersistenciaSql extends Persistencia {

	public void persistir() {
		
		
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

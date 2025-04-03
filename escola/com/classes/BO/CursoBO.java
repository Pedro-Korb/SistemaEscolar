package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Curso;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class CursoBO {

    public boolean inserirCurso(Curso curso){
        if (existeCurso(curso) != true) {
        	CursoDAO cursodao = new CursoDAO();
            return cursodao.inserirCurso(curso);
        }
        return false;
    }
    
    public boolean inserirFaseCurso(int id_fase, int id_curso){
    	CursoDAO cursofao = new CursoDAO();
    	if (id_fase > 0 && id_curso > 0)
    		return cursofao.inserirFaseCurso(id_fase, id_curso);
    	return false;
    }
    
    public List<Curso> pesquisarTodos(){
    	CursoDAO cursodao = new CursoDAO();
        return cursodao.pesquisarTodos();
    }
    
    public boolean existeCurso(Curso curso){
    	CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.existeCurso(curso);
    }
    
    public boolean existeProfessor(Professor prof){
    	ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.existe(prof);
    }
    
    public Curso procurarPorCodigo(int codigo){
    	CursoDAO cursodao = new CursoDAO();
        return cursodao.procurarPorCodigo(codigo);
    }
}
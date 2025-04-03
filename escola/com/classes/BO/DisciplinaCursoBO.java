package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaCurso;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.DisciplinaCursoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class DisciplinaCursoBO {

    public boolean inserirDisciplinaCurso(DisciplinaCurso disciplinaCurso){
        if (existeDisciplinaCurso(disciplinaCurso) != true) {
        	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
            return discicursodao.inserirDisciplinaCurso(disciplinaCurso);
        }
        return false;
    }
    
    public boolean inserirRegistroAcademicoDisciplinaCurso(int id_registro_academico, int id_disciplina_curso){
    	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
    	if (id_registro_academico > 0 && id_disciplina_curso > 0)
    		return discicursodao.inserirRegistroAcademicoDisciplinaCurso(id_registro_academico, id_disciplina_curso);
    	return false;
    }
    
    public boolean inserirAvaliacaoDisciplinaCurso(int id_avaliacao, int id_disciplina_curso){
    	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
    	if (id_avaliacao > 0 && id_disciplina_curso > 0)
    		return discicursodao.inserirAvaliacaoDisciplinaCurso(id_avaliacao, id_disciplina_curso);
    	return false;
    }
    
    public List<DisciplinaCurso> pesquisarTodos(){
    	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
        return discicursodao.pesquisarTodos();
    }
    
    public boolean existeDisciplinaCurso(DisciplinaCurso disciplinaCurso){
    	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
        return discicursodao.existeDisciplinaCurso(disciplinaCurso);
    }
    
    public boolean existeProfessor(Professor prof){
    	ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.existe(prof);
    }
    
    public DisciplinaCurso procurarPorCodigo(int codigo){
    	DisciplinaCursoDAO discicursodao = new DisciplinaCursoDAO();
        return discicursodao.procurarPorCodigo(codigo);
    }
}
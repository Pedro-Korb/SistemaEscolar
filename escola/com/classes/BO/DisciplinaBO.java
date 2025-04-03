package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class DisciplinaBO {

    public boolean inserirDisciplina(Disciplina disci){
        if (existeDisciplina(disci) != true) {
        	DisciplinaDAO disciDAO = new DisciplinaDAO();
            return disciDAO.inserirDisciplina(disci);
        }
        return false;
    }
    
    public boolean inserirProfessorDisciplina(int id_professor, int id_disciplina){
    	DisciplinaDAO disciDAO = new DisciplinaDAO();
    	if (id_professor > 0 && id_disciplina > 0)
    		return disciDAO.inserirProfessorDisciplina(id_professor, id_disciplina);
    	return false;
    }
    
    public List<Disciplina> pesquisarTodos(){
    	DisciplinaDAO marcasDAO = new DisciplinaDAO();
        return marcasDAO.pesquisarTodos();
    }
    
    public boolean existeDisciplina(Disciplina prof){
    	DisciplinaDAO disciDAO = new DisciplinaDAO();
        return disciDAO.existe(prof);
    }
    
    public boolean existeProfessor(Professor prof){
    	ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.existe(prof);
    }
    public Disciplina procurarPorCodigo(int codigo){
    	DisciplinaDAO discdao = new DisciplinaDAO();
        return discdao.procurarPorCodigo(codigo);
    }
}
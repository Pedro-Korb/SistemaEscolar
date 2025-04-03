package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.FaseDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class FaseBO {

    public boolean inserirFase(Fase fase){
        if (existeFase(fase) != true) {
        	FaseDAO fasedao = new FaseDAO();
            return fasedao.inserirFase(fase);
        }
        return false;
    }
    
    public boolean inserirDisciplinaFase(int id_disciplina, int id_fase){
    	FaseDAO fasefao = new FaseDAO();
    	if (id_disciplina > 0 && id_fase > 0)
    		return fasefao.inserirDisciplinaFase(id_disciplina, id_fase);
    	return false;
    }
    
    public List<Fase> pesquisarTodos(){
    	FaseDAO fasedao = new FaseDAO();
        return fasedao.pesquisarTodos();
    }
    
    public boolean existeFase(Fase fase){
    	FaseDAO faseDAO = new FaseDAO();
        return faseDAO.existeFase(fase);
    }
    
    public boolean existeProfessor(Professor prof){
    	ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.existe(prof);
    }
    
    public Fase procurarPorCodigo(int codigo){
    	FaseDAO fasedao = new FaseDAO();
        return fasedao.procurarPorCodigo(codigo);
    }
}
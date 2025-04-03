package com.classes.BO;

import com.classes.DTO.Professor;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class ProfessorBO {

    public boolean inserir(Professor prof){
        if (existe(prof) != true) {
        	ProfessorDAO marcasDAO = new ProfessorDAO();
            return marcasDAO.inserir(prof);
        }
        return false;
    }
    public List<Professor> pesquisarTodos(){
    	ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.pesquisarTodos();
    }
    
    public boolean existe(Professor prof){
    	ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.existe(prof);
    }
    
    public Professor procurarPorCodigo(int codigo){
        ProfessorDAO profdao = new ProfessorDAO();
        return profdao.procurarPorCodigo(codigo);
    }
}
package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.RegistroAcademico;
import com.classes.DTO.Curso;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.RegistroAcademicoDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class RegistroAcademicoBO {

    public boolean inserirRegistroAcademico(RegistroAcademico regacad){
        if (existeRegistroAcademico(regacad) != true) {
        	RegistroAcademicoDAO regacadao = new RegistroAcademicoDAO();
            return regacadao.inserirRegistroAcademico(regacad);
        }
        return false;
    }
    
    public boolean existeRegistroAcademico(RegistroAcademico regacad){
    	RegistroAcademicoDAO regacadao = new RegistroAcademicoDAO();
        return regacadao.existeRegistroAcademico(regacad);
    }
    
    
    public RegistroAcademico procurarPorCodigo(int codigo){
    	RegistroAcademicoDAO regacadao = new RegistroAcademicoDAO();
        return regacadao.procurarPorCodigo(codigo);
    }
    
    public List<RegistroAcademico> pesquisarTodos(){
    	RegistroAcademicoDAO regacadao = new RegistroAcademicoDAO();
        return regacadao.pesquisarTodos();
    }
}
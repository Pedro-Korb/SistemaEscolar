package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.PresencaAluno;
import com.classes.DTO.Curso;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.PresencaAlunoDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class PresencaAlunoBO {

    public boolean inserirPresencaAluno(PresencaAluno presal){
        if (existePresencaAluno(presal) != true) {
        	PresencaAlunoDAO presaldao = new PresencaAlunoDAO();
            return presaldao.inserirPresencaAluno(presal);
        }
        return false;
    }
    
    public boolean existePresencaAluno(PresencaAluno presal){
    	PresencaAlunoDAO presaldao = new PresencaAlunoDAO();
        return presaldao.existePresencaAluno(presal);
    }
    
    
    public PresencaAluno procurarPresencaPorCodigoAluno(int codigo){
    	PresencaAlunoDAO presaldao = new PresencaAlunoDAO();
        return presaldao.procurarPresencaPorCodigoAluno(codigo);
    }
    
    public List<PresencaAluno> pesquisarTodos(){
    	PresencaAlunoDAO presaldao = new PresencaAlunoDAO();
        return presaldao.pesquisarTodos();
    }
}
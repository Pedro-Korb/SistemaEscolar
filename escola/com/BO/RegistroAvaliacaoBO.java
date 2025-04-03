package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.PresencaAluno;
import com.classes.DTO.Curso;
import com.classes.DTO.Professor;
import com.classes.DTO.RegistroAvaliacao;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.PresencaAlunoDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.ProfessorDAO;
import com.classes.DAO.RegistroAvaliacaoDAO;

import java.util.List;

public class RegistroAvaliacaoBO {

    public boolean inserirRegistroAvaliacao(RegistroAvaliacao regav){
        if (existeRegistroAvaliacao(regav) != true) {
        	RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
            return regavdao.inserirRegistroAvaliacao(regav);
        }
        return false;
    }
    
    public boolean existeRegistroAvaliacao(RegistroAvaliacao regav){
    	RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
        return regavdao.existeRegistroAvaliacao(regav);
    }
    
    
    public RegistroAvaliacao procurarRegistroAvaliacaoPorCodigoAluno(int codigo){
    	RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
        return regavdao.procurarRegistroAvaliacaoPorCodigoAluno(codigo);
    }
    
    public List<RegistroAvaliacao> pesquisarTodos(){
    	RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
        return regavdao.pesquisarTodos();
    }
}
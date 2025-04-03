package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Avaliacao;
import com.classes.DTO.Curso;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.AvaliacaoDAO;
import com.classes.DAO.CursoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class AvaliacaoBO {

    public boolean inserirAvaliacao(Avaliacao ava){
        if (existeAvaliacao(ava) != true) {
        	AvaliacaoDAO avadao = new AvaliacaoDAO();
            return avadao.inserirAvaliacao(ava);
        }
        return false;
    }
    
    public boolean existeAvaliacao(Avaliacao ava){
    	AvaliacaoDAO avadao = new AvaliacaoDAO();
        return avadao.existeAvaliacao(ava);
    }
    
    
    public Avaliacao procurarPorCodigo(int codigo){
    	AvaliacaoDAO avadao = new AvaliacaoDAO();
        return avadao.procurarPorCodigo(codigo);
    }
    
    public List<Avaliacao> pesquisarTodos(){
    	AvaliacaoDAO avadao = new AvaliacaoDAO();
        return avadao.pesquisarTodos();
    }
}
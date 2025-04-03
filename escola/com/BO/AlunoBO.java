package com.classes.BO;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Aluno;
import com.classes.DTO.Professor;
import com.classes.DAO.DisciplinaDAO;
import com.classes.DAO.AlunoDAO;
import com.classes.DAO.ProfessorDAO;
import java.util.List;

public class AlunoBO {

    public boolean inserirAluno(Aluno aluno){
        if (existeAluno(aluno) != true) {
        	AlunoDAO alunodao = new AlunoDAO();
            return alunodao.inserirAluno(aluno);
        }
        return false;
    }
    
    public boolean inserirDisciplinaCursoAluno(int id_disciplina_curso, int id_aluno){
    	AlunoDAO alunofao = new AlunoDAO();
    	if (id_disciplina_curso > 0 && id_aluno > 0)
    		return alunofao.inserirDisciplinaCursoAluno(id_disciplina_curso, id_aluno);
    	return false;
    }
    
    public List<Aluno> pesquisarTodos(){
    	AlunoDAO alunodao = new AlunoDAO();
        return alunodao.pesquisarTodos();
    }
    
    public boolean existeAluno(Aluno aluno){
    	AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.existeAluno(aluno);
    }
    
    public Aluno procurarPorCodigo(int codigo){
    	AlunoDAO alunodao = new AlunoDAO();
        return alunodao.procurarPorCodigo(codigo);
    }
}
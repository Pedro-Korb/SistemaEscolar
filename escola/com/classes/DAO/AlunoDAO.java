package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Aluno;
import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaCursoBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class AlunoDAO {
	
final String NOMEDATABELA = "aluno";
    
    public boolean inserirAluno(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_curso, nome_aluno) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getCurso().getId_curso());
            ps.setString(2, aluno.getNome_aluno());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirDisciplinaCursoAluno(int id_disciplina_curso, int id_aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO disciplina_curso_aluno (id_disciplina_curso, id_aluno) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_disciplina_curso);
            ps.setInt(2, id_aluno);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public Aluno procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_aluno = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            CursoBO cursobo = new CursoBO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Aluno aluno = new Aluno();
            	aluno.setId_aluno(rs.getInt(1));
            	aluno.setCurso(cursobo.procurarPorCodigo(rs.getInt(2)));
            	aluno.setNome_aluno(rs.getString(3));
                ps.close();
                rs.close();
                conn.close();
                return aluno;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public boolean existeAluno(Aluno aluno) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome_aluno = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, aluno.getNome_aluno());
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    			ps.close();
    			rs.close();
    			conn.close();
    			return true;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return false;
    }
    
    public List<Aluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select aluno.id_aluno,\r\n"
            		+ "	   		 aluno.id_curso,\r\n"
            		+ "	   		 aluno.nome_aluno,\r\n"
            		+ "	   		 disciplina_curso_aluno.id_disciplina_curso\r\n"
            		+ "	 	from aluno\r\n"
            		+ "	    left join disciplina_curso_aluno\r\n"
            		+ "	      on aluno.id_aluno = disciplina_curso_aluno.id_aluno;  ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Aluno> montarLista(ResultSet rs) {
        List<Aluno> listObj = new ArrayList<Aluno>();
        DisciplinaCursoBO discicursobo = new DisciplinaCursoBO();
        CursoBO cursobo = new CursoBO();
        try {
            while (rs.next()) {
            	Aluno aluno = new Aluno();
            	aluno.setId_aluno(rs.getInt(1));
            	aluno.setCurso(cursobo.procurarPorCodigo(rs.getInt(2)));
            	aluno.setNome_aluno(rs.getString(3));
            	aluno.adicionarDisciplinasRelacionadas(discicursobo.procurarPorCodigo(rs.getInt(4)));
                listObj.add(aluno);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

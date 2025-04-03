package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Curso;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class CursoDAO {
	
final String NOMEDATABELA = "curso";
    
    public boolean inserirCurso(Curso curso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome_curso) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNome_curso());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirFaseCurso(int id_fase, int id_curso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO fase_curso (id_fase, id_curso) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_fase);
            ps.setInt(2, id_curso);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public Curso procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_curso = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Curso curso = new Curso();
            	curso.setId_curso(rs.getInt(1));
            	curso.setNome_curso(rs.getString(2));
                ps.close();
                rs.close();
                conn.close();
                return curso;
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
    public boolean existeCurso(Curso curso) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome_curso = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, curso.getNome_curso());
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
    
    public List<Curso> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select \r\n"
            		+ "		fase.id_fase,\r\n"
            		+ "	   fase.numero_fase,\r\n"
            		+ "	   curso.id_curso,\r\n"
            		+ "	   curso.nome_curso\r\n"
            		+ "	   from escola.fase\r\n"
            		+ "	   left join escola.fase_curso\r\n"
            		+ "	   on fase.id_fase = fase_curso.id_fase\r\n"
            		+ "	   left join escola.curso\r\n"
            		+ "	    on fase_curso.id_curso = curso.id_curso;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Curso> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Curso> montarLista(ResultSet rs) {
        List<Curso> listObj = new ArrayList<Curso>();
        FaseBO fasbo = new FaseBO();
        try {
            while (rs.next()) {
            	Curso curso = new Curso();
            	curso.setId_curso(rs.getInt(3));
            	curso.setNome_curso(rs.getString(4));
            	curso.adicionarFase(fasbo.procurarPorCodigo(rs.getInt(1)));
                listObj.add(curso);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

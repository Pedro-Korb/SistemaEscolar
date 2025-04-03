package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Professor;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class DisciplinaDAO {
	
final String NOMEDATABELA = "disciplina";
    
    public boolean inserirDisciplina(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome_disciplina) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, disciplina.getNome_disciplina());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirProfessorDisciplina(int id_professor, int id_disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO professor_disciplina (id_professor, id_disciplina) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_professor);
            ps.setInt(2, id_disciplina);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean existe(Disciplina disciplina) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome_disciplina = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, disciplina.getNome_disciplina());
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
    
    public Disciplina procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Disciplina disc = new Disciplina();
            	disc.setId_disciplina(rs.getInt(1));
                disc.setNome_disciplina(rs.getString(2));
                ps.close();
                rs.close();
                conn.close();
                return disc;
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
    
    public List<Disciplina> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select disciplina.id_disciplina,\r\n"
            		+ "	   	     disciplina.nome_disciplina,\r\n"
            		+ "	         professor.id_professor,\r\n"
            		+ "	         professor.nome_professor,\r\n"
            		+ "	         professor.especialidade_professor\r\n"
            		+ "	    from escola.disciplina\r\n"
            		+ "	    left join escola.professor_disciplina\r\n"
            		+ "   	  on disciplina.id_disciplina = professor_disciplina.id_disciplina\r\n"
            		+ "   	left join escola.professor\r\n"
            		+ "   	  on professor.id_professor = professor_disciplina.id_professor;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Disciplina> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Disciplina> montarLista(ResultSet rs) {
        List<Disciplina> listObj = new ArrayList<Disciplina>();
        ProfessorBO profbo = new ProfessorBO();
        try {
            while (rs.next()) {
            	Disciplina disciplina = new Disciplina();
            	disciplina.setId_disciplina(rs.getInt(1));
            	disciplina.setNome_disciplina(rs.getString(2));
            	disciplina.adicionarProfessor(profbo.procurarPorCodigo(rs.getInt(3)));
                listObj.add(disciplina);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

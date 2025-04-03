package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Professor;
import com.classes.Conexao.Conexao;


public class ProfessorDAO {
	
final String NOMEDATABELA = "professor";
    
    public boolean inserir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome_professor, especialidade_professor) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome_professor());
            ps.setString(2, professor.getEspecialidade_professor());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean existe(Professor professor) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome_professor = (?);";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, professor.getNome_professor());
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
    
    public List<Professor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Professor> montarLista(ResultSet rs) {
        List<Professor> listObj = new ArrayList<Professor>();
        try {
            while (rs.next()) {
            	Professor professor = new Professor();
            	professor.setId_professor(rs.getInt(1));
            	professor.setNome_professor(rs.getString(2));
            	professor.setEspecialidade_professor(rs.getString(3));
                listObj.add(professor);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Professor procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_professor = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor prof = new Professor();
                prof.setId_professor(rs.getInt(1));
                prof.setNome_professor(rs.getString(2));
                prof.setEspecialidade_professor(rs.getString(3));
                ps.close();
                rs.close();
                conn.close();
                return prof;
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
    
}

package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Avaliacao;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class AvaliacaoDAO {
	
final String NOMEDATABELA = "avaliacao";
    
    public boolean inserirAvaliacao(Avaliacao avaliacao) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_registro_avaliacao, data_avaliacao, numero_avaliacao, id_professor) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, avaliacao.getRegistro_avaliacao().getId_registro_avaliacao());
            ps.setString(1, avaliacao.getData_avaliacao());
            ps.setInt(1, avaliacao.getNumeracao_avaliacao());
            ps.setInt(1, avaliacao.getProfessor().getId_professor());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public Avaliacao procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_avaliacao = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
            ProfessorDAO profdao = new ProfessorDAO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Avaliacao avaliacao = new Avaliacao();
            	avaliacao.setId_avaliacao(rs.getInt(1));
            	avaliacao.setRegistro_avaliacao(regavdao.procurarRegistroAvaliacaoPorCodigoAluno(rs.getInt(2)));
            	avaliacao.setData_avaliacao(rs.getString(3));
            	avaliacao.setNumeracao_avaliacao(rs.getInt(4));
            	avaliacao.setProfessor(profdao.procurarPorCodigo(rs.getInt(5)));
                ps.close();
                rs.close();
                conn.close();
                return avaliacao;
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
    public boolean existeAvaliacao(Avaliacao avaliacao) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_avaliacao = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, avaliacao.getId_avaliacao());
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
    
    public List<Avaliacao> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select * from " + NOMEDATABELA + ";";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Avaliacao> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Avaliacao> montarLista(ResultSet rs) {
        List<Avaliacao> listObj = new ArrayList<Avaliacao>();
        RegistroAvaliacaoDAO regavdao = new RegistroAvaliacaoDAO();
        ProfessorDAO profdao = new ProfessorDAO();
        try {
            while (rs.next()) {
            	Avaliacao avaliacao = new Avaliacao();
            	avaliacao.setId_avaliacao(rs.getInt(1));
            	avaliacao.setRegistro_avaliacao(regavdao.procurarRegistroAvaliacaoPorCodigoAluno(rs.getInt(2)));
            	avaliacao.setData_avaliacao(rs.getString(3));
            	avaliacao.setNumeracao_avaliacao(rs.getInt(4));
            	avaliacao.setProfessor(profdao.procurarPorCodigo(rs.getInt(5)));
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

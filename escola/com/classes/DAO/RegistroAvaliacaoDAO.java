package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.RegistroAvaliacao;
import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class RegistroAvaliacaoDAO {
	
final String NOMEDATABELA = "registro_avaliacao";
    
    public boolean inserirRegistroAvaliacao(RegistroAvaliacao registroAvaliacao) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_aluno, nota_avaliacao) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, registroAvaliacao.getAluno().getId_aluno());
            ps.setDouble(1, registroAvaliacao.getNota_aluno());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public RegistroAvaliacao procurarRegistroAvaliacaoPorCodigoAluno(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_registro_avaliacao = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            AlunoBO albo = new AlunoBO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	RegistroAvaliacao regav = new RegistroAvaliacao();
            	regav.setId_registro_avaliacao(rs.getInt(1));
            	regav.setAluno(albo.procurarPorCodigo(rs.getInt(2)));
            	regav.setNota_aluno(rs.getDouble(3));
                ps.close();
                rs.close();
                conn.close();
                return regav;
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
    public boolean existeRegistroAvaliacao(RegistroAvaliacao regav) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_registro_avaliacao = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, regav.getId_registro_avaliacao());
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
    
    public List<RegistroAvaliacao> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select * from " + NOMEDATABELA + ";";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<RegistroAvaliacao> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<RegistroAvaliacao> montarLista(ResultSet rs) {
        List<RegistroAvaliacao> listObj = new ArrayList<RegistroAvaliacao>();
        AlunoBO albo = new AlunoBO();
        try {
            while (rs.next()) {
            	RegistroAvaliacao presal = new RegistroAvaliacao();
            	presal.setId_registro_avaliacao(rs.getInt(1));
            	presal.setAluno(albo.procurarPorCodigo(rs.getInt(2))); //buscar aluno por codigo
            	presal.setNota_aluno(rs.getInt(3));
                listObj.add(presal);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

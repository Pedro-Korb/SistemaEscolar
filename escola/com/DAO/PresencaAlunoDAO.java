package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.PresencaAluno;
import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class PresencaAlunoDAO {
	
final String NOMEDATABELA = "presenca_aluno";
    
    public boolean inserirPresencaAluno(PresencaAluno presencaAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_aluno, numero_presencas_presenca_aluno) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presencaAluno.getAluno().getId_aluno());
            ps.setInt(2, presencaAluno.getNumero_presencas());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public PresencaAluno procurarPresencaPorCodigoAluno(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_aluno = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            AlunoBO albo = new AlunoBO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	PresencaAluno preal = new PresencaAluno();
            	preal.setId_presenca_aluno(rs.getInt(1));
            	preal.setNumero_presencas(rs.getInt(3));
            	preal.setAluno(albo.procurarPorCodigo(rs.getInt(2))); // utilizar procuraAlunoPorCodigo para adicionar aluno aqui dentro
                ps.close();
                rs.close();
                conn.close();
                return preal;
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
    public boolean existePresencaAluno(PresencaAluno presal) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_presenca_aluno = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, presal.getId_presenca_aluno());
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
    
    public List<PresencaAluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select * from " + NOMEDATABELA + ";";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PresencaAluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<PresencaAluno> montarLista(ResultSet rs) {
        List<PresencaAluno> listObj = new ArrayList<PresencaAluno>();
        AlunoBO albo = new AlunoBO();
        try {
            while (rs.next()) {
            	PresencaAluno presal = new PresencaAluno();
            	presal.setId_presenca_aluno(rs.getInt(1));
            	presal.setAluno(albo.procurarPorCodigo(rs.getInt(2))); //buscar aluno por codigo
            	presal.setNumero_presencas(rs.getInt(3));
                listObj.add(presal);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

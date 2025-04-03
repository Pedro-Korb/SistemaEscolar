package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.RegistroAcademico;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class RegistroAcademicoDAO {
	
final String NOMEDATABELA = "registro_academico";
    
    public boolean inserirRegistroAcademico(RegistroAcademico registroAcademico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_presenca_aluno, data_registro_academico, numero_aulas_registro_academico, id_professor) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, registroAcademico.getPresenca_aluno().getId_presenca_aluno());
            ps.setString(1, registroAcademico.getData_registro_academico());
            ps.setInt(1, registroAcademico.getNumero_aulas());
            ps.setInt(1, registroAcademico.getProfessor().getId_professor());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public RegistroAcademico procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_registro_academico = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            PresencaAlunoDAO presalbo = new PresencaAlunoDAO();
            ProfessorDAO profdao = new ProfessorDAO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	RegistroAcademico registroAcademico = new RegistroAcademico();
            	registroAcademico.setId_registro_academico(rs.getInt(1));
            	registroAcademico.setPresenca_aluno(presalbo.procurarPresencaPorCodigoAluno(rs.getInt(2)));
            	registroAcademico.setData_registro_academico(rs.getString(3));
            	registroAcademico.setNumero_aulas(rs.getInt(4));
            	registroAcademico.setProfessor(profdao.procurarPorCodigo(rs.getInt(5)));
                ps.close();
                rs.close();
                conn.close();
                return registroAcademico;
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
    public boolean existeRegistroAcademico(RegistroAcademico registroAcademico) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_registro_academico = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, registroAcademico.getId_registro_academico());
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
    
    public List<RegistroAcademico> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select * from " + NOMEDATABELA + ";";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<RegistroAcademico> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<RegistroAcademico> montarLista(ResultSet rs) {
        List<RegistroAcademico> listObj = new ArrayList<RegistroAcademico>();
        PresencaAlunoDAO presalbo = new PresencaAlunoDAO();
        ProfessorDAO profdao = new ProfessorDAO();
        try {
            while (rs.next()) {
            	RegistroAcademico registroAcademico = new RegistroAcademico();
            	registroAcademico.setId_registro_academico(rs.getInt(1));
            	registroAcademico.setPresenca_aluno(presalbo.procurarPresencaPorCodigoAluno(rs.getInt(2)));
            	registroAcademico.setData_registro_academico(rs.getString(3));
            	registroAcademico.setNumero_aulas(rs.getInt(4));
            	registroAcademico.setProfessor(profdao.procurarPorCodigo(rs.getInt(5)));
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

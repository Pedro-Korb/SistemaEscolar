package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaCurso;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class DisciplinaCursoDAO {
	
final String NOMEDATABELA = "disciplina_curso";
    
    public boolean inserirDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_disciplina, situacao_disciplina_curso, ano_semestre_disciplina_curso) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, disciplinaCurso.getDisciplina().getId_disciplina());
            ps.setString(2, disciplinaCurso.getSituacao());
            ps.setString(3, disciplinaCurso.getAno_semestre());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirRegistroAcademicoDisciplinaCurso(int id_registro_academico, int id_disciplina_curso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO registro_academico_disciplina_curso (id_registro_academico, id_disciplina_curso) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_registro_academico);
            ps.setInt(2, id_disciplina_curso);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirAvaliacaoDisciplinaCurso(int id_avaliacao, int id_disciplina_curso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO avaliacao_disciplina_curso (id_avaliacao, id_disciplina_curso) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_avaliacao);
            ps.setInt(2, id_disciplina_curso);
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
   
    public DisciplinaCurso procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina_curso = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            DisciplinaDAO discidao = new DisciplinaDAO();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	DisciplinaCurso disciplinaCurso = new DisciplinaCurso();
            	disciplinaCurso.setId_disciplina_curso(rs.getInt(1));
            	disciplinaCurso.setDisciplina(discidao.procurarPorCodigo(rs.getInt(2)));
            	disciplinaCurso.setSituacao(rs.getString(3));
            	disciplinaCurso.setAno_semestre(rs.getString(4));
                ps.close();
                rs.close();
                conn.close();
                return disciplinaCurso;
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
    public boolean existeDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina_curso = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, disciplinaCurso.getId_disciplina_curso());
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
    
    public List<DisciplinaCurso> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select disciplina_curso.id_disciplina_curso,\r\n"
            		+ "	   	 	 disciplina_curso.id_disciplina,\r\n"
            		+ "	   		 disciplina_curso.situacao_disciplina_curso,\r\n"
            		+ "	   		 disciplina_curso.ano_semestre_disciplina_curso,\r\n"
            		+ "	  		 registro_academico_disciplina_curso.id_registro_academico,\r\n"
            		+ "	   		 avaliacao_disciplina_curso.id_avaliacao \r\n"
            		+ "		from disciplina_curso\r\n"
            		+ "		left join registro_academico_disciplina_curso\r\n"
            		+ "	 	  on disciplina_curso.id_disciplina_curso = registro_academico_disciplina_curso.id_registro_academico\r\n"
            		+ "	    left join avaliacao_disciplina_curso\r\n"
            		+ "	 	  on disciplina_curso.id_disciplina_curso = avaliacao_disciplina_curso.id_disciplina_curso;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaCurso> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<DisciplinaCurso> montarLista(ResultSet rs) {
        List<DisciplinaCurso> listObj = new ArrayList<DisciplinaCurso>();
        RegistroAcademicoDAO regacaddao = new RegistroAcademicoDAO();
        AvaliacaoDAO avadao = new AvaliacaoDAO();
        DisciplinaDAO discidao = new DisciplinaDAO();
        try {
            while (rs.next()) {
            	DisciplinaCurso disciplinaCurso = new DisciplinaCurso();
            	
            	disciplinaCurso.setId_disciplina_curso(rs.getInt(1));
            	disciplinaCurso.setDisciplina(discidao.procurarPorCodigo(rs.getInt(2)));
            	disciplinaCurso.setSituacao(rs.getString(3));
            	disciplinaCurso.setAno_semestre(rs.getString(4));
            	disciplinaCurso.adicionarRegistroAcademico(regacaddao.procurarPorCodigo(rs.getInt(5)));
            	disciplinaCurso.adicionarAvalicao(avadao.procurarPorCodigo(rs.getInt(6)));
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

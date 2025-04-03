package com.classes.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;


public class FaseDAO {
	
final String NOMEDATABELA = "fase";
    
    public boolean inserirFase(Fase fase) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (numero_fase) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, fase.getNumero_fase());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean inserirDisciplinaFase(int id_disciplina, int id_fase) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO disciplina_fase (id_disciplina, id_fase) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id_disciplina);
            ps.setInt(2, id_fase);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public Fase procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_fase = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Fase fase = new Fase();
            	fase.setId_fase(rs.getInt(1));
            	fase.setNumero_fase(rs.getInt(2));
                ps.close();
                rs.close();
                conn.close();
                return fase;
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
    public boolean existeFase(Fase fase) {
    	try {
    		Connection conn = Conexao.conectar();
    		String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE numero_fase = ?;";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, fase.getNumero_fase());
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
    
    public List<Fase> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "select disciplina.id_disciplina,\r\n"
            		+ "	   	  	 disciplina.nome_disciplina,\r\n"
            		+ "	   		 fase.numero_fase,\r\n"
            		+ "	   		 fase.id_fase \r\n"
            		+ "	 	from escola.disciplina\r\n"
            		+ "	    left join escola.disciplina_fase\r\n"
            		+ "	 	  on disciplina.id_disciplina = disciplina_fase.id_disciplina\r\n"
            		+ "	 	left join escola.fase\r\n"
            		+ "	 	  on disciplina_fase.id_fase = fase.id_fase ;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Fase> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Fase> montarLista(ResultSet rs) {
        List<Fase> listObj = new ArrayList<Fase>();
        DisciplinaBO discbo = new DisciplinaBO();
        try {
            while (rs.next()) {
            	Fase fase = new Fase();
            	fase.adicionarDisciplina(discbo.procurarPorCodigo(rs.getInt(1)));
            	fase.setNumero_fase(rs.getInt(3));
            	fase.setId_fase(rs.getInt(4));
                listObj.add(fase);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

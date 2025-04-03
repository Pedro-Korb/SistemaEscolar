package com.classes.main;

import com.classes.Conexao.Conexao;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class PersistenciaJson extends Persistencia {

	public void persistir() {
        Connection conn = Conexao.conectar();
        if (conn == null) {
            System.out.println("Erro ao conectar ao banco!");
            return;
        }

        try (Statement stmtCursos = conn.createStatement();
             ResultSet rsCursos = stmtCursos.executeQuery("SELECT * FROM escola.curso")) {

            JSONArray cursosArray = new JSONArray();

            while (rsCursos.next()) {
                int idCurso = rsCursos.getInt("id_curso");
                String nomeCurso = rsCursos.getString("nome_curso");

                JSONObject cursoObject = new JSONObject();
                cursoObject.put("ID", idCurso);
                cursoObject.put("Nome", nomeCurso);

                JSONArray fasesArray = new JSONArray();

                try (Statement stmtFases = conn.createStatement();
                     ResultSet rsFases = stmtFases.executeQuery("SELECT f.id_fase, f.numero_fase FROM escola.fase f " +
                             "JOIN escola.fase_curso fc ON f.id_fase = fc.id_fase WHERE fc.id_curso = " + idCurso)) {

                    while (rsFases.next()) {
                        int idFase = rsFases.getInt("id_fase");
                        int numeroFase = rsFases.getInt("numero_fase");

                        JSONObject faseObject = new JSONObject();
                        faseObject.put("ID", idFase);
                        faseObject.put("Numero", numeroFase);

                        JSONArray disciplinasArray = new JSONArray();

                        try (Statement stmtDisciplinas = conn.createStatement();
                             ResultSet rsDisciplinas = stmtDisciplinas.executeQuery("SELECT d.id_disciplina, d.nome_disciplina FROM escola.disciplina d " +
                                     "JOIN escola.disciplina_fase df ON d.id_disciplina = df.id_disciplina WHERE df.id_fase = " + idFase)) {

                            while (rsDisciplinas.next()) {
                                int idDisciplina = rsDisciplinas.getInt("id_disciplina");
                                String nomeDisciplina = rsDisciplinas.getString("nome_disciplina");

                                JSONObject disciplinaObject = new JSONObject();
                                disciplinaObject.put("ID", idDisciplina);
                                disciplinaObject.put("Nome", nomeDisciplina);

                                disciplinasArray.put(disciplinaObject);
                            }
                        }

                        faseObject.put("Disciplinas", disciplinasArray);
                        fasesArray.put(faseObject);
                    }
                }

                cursoObject.put("Fases", fasesArray);
                cursosArray.put(cursoObject);
            }

            JSONObject jsonOutput = new JSONObject();
            jsonOutput.put("RelacaoGeralDisciplinaFaseCurso", cursosArray);

            try (FileWriter file = new FileWriter("C:/Users/User/Desktop/persistencia_json/cursos.json")) {
                file.write(jsonOutput.toString(4));
                System.out.println("Arquivo JSON criado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

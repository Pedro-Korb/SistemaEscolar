package com.classes.main;

//SaveDBToXML.java


import com.classes.Conexao.Conexao;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PersistenciaXml extends Persistencia {
    public void persistir() {

        Connection conn = Conexao.conectar();
        if (conn == null) {
            System.out.println("Erro ao conectar ao banco!");
            return;
        }

        try (Statement stmtCursos = conn.createStatement();
             ResultSet rsCursos = stmtCursos.executeQuery("SELECT * FROM escola.curso")) {

            // Criar documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Elemento raiz
            Element rootElement = doc.createElement("RelacaoGeralDisciplinaFaseCurso");
            doc.appendChild(rootElement);

            while (rsCursos.next()) {
                int idCurso = rsCursos.getInt("id_curso");
                String nomeCurso = rsCursos.getString("nome_curso");

                Element cursoElement = doc.createElement("Curso");

                Element idElement = doc.createElement("ID");
                idElement.appendChild(doc.createTextNode(String.valueOf(idCurso)));
                cursoElement.appendChild(idElement);

                Element nomeElement = doc.createElement("Nome");
                nomeElement.appendChild(doc.createTextNode(nomeCurso));
                cursoElement.appendChild(nomeElement);

                Element fasesElement = doc.createElement("Fases");
                cursoElement.appendChild(fasesElement);

                // Buscar fases do curso
                try (Statement stmtFases = conn.createStatement();
                     ResultSet rsFases = stmtFases.executeQuery("SELECT \r\n"
								                     		+ "    f.id_fase, \r\n"
								                     		+ "    f.numero_fase\r\n"
								                     		+ "FROM escola.fase f\r\n"
								                     		+ "JOIN escola.fase_curso fc ON f.id_fase = fc.id_fase\r\n"
								                     		+ "WHERE fc.id_curso = " + idCurso + ";")) {

                    while (rsFases.next()) {
                        int idFase = rsFases.getInt("id_fase");
                        int numeroFase = rsFases.getInt("numero_fase");

                        Element faseElement = doc.createElement("Fase");

                        Element idFaseElement = doc.createElement("ID");
                        idFaseElement.appendChild(doc.createTextNode(String.valueOf(idFase)));
                        faseElement.appendChild(idFaseElement);

                        Element numeroElement = doc.createElement("Numero");
                        numeroElement.appendChild(doc.createTextNode(String.valueOf(numeroFase)));
                        faseElement.appendChild(numeroElement);

                        Element disciplinasElement = doc.createElement("Disciplinas");
                        faseElement.appendChild(disciplinasElement);

                        // Buscar disciplinas da fase
                        try (Statement stmtDisciplinas = conn.createStatement();
                             ResultSet rsDisciplinas = stmtDisciplinas.executeQuery("SELECT \r\n"
						                             		+ "    disciplina.id_disciplina, \r\n"
						                             		+ "    disciplina.nome_disciplina\r\n"
						                             		+ "FROM escola.disciplina\r\n"
						                             		+ "JOIN escola.disciplina_fase ON disciplina.id_disciplina = disciplina_fase.id_disciplina\r\n"
						                             		+ "WHERE disciplina_fase.id_fase = " + idFase + ";")) {

                            while (rsDisciplinas.next()) {
                                int idDisciplina = rsDisciplinas.getInt("id_disciplina");
                                String nomeDisciplina = rsDisciplinas.getString("nome_disciplina");

                                Element disciplinaElement = doc.createElement("Disciplina");

                                Element idDisciplinaElement = doc.createElement("ID");
                                idDisciplinaElement.appendChild(doc.createTextNode(String.valueOf(idDisciplina)));
                                disciplinaElement.appendChild(idDisciplinaElement);

                                Element nomeDisciplinaElement = doc.createElement("Nome");
                                nomeDisciplinaElement.appendChild(doc.createTextNode(nomeDisciplina));
                                disciplinaElement.appendChild(nomeDisciplinaElement);

                                disciplinasElement.appendChild(disciplinaElement);
                            }
                        }

                        fasesElement.appendChild(faseElement);
                    }
                }

                rootElement.appendChild(cursoElement);
            }

            // Salvar XML em arquivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:/Users/User/Desktop/persistencia_xml/cursos.xml"));

            transformer.transform(source, result);
            System.out.println("Arquivo XML criado com sucesso!");

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
